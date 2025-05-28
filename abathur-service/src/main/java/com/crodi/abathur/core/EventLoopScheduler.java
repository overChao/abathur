package com.crodi.abathur.core;

import com.crodi.abathur.config.ThreadPoolProperties;
import org.springframework.context.SmartLifecycle;
import org.springframework.stereotype.Component;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * @author Crodi
 * @date 2025/4/14 16:12
 * @description: TODO
 */

@Component
public class EventLoopScheduler implements SmartLifecycle {

    // eventLoop 任务队列
    private final BlockingQueue<Runnable> taskQueue;

    // 作业线程池 （单工作线程池）
    private final ExecutorService workerPool;

    // 配置
    private final ThreadPoolProperties properties;


    private final AtomicBoolean running = new AtomicBoolean(Boolean.FALSE);

    // 事件循环线程
    private Thread eventLoopThread;


    public EventLoopScheduler(ThreadPoolProperties properties) {
        this.properties = properties;
        this.taskQueue = new LinkedBlockingDeque<>(properties.getQueueCapacity());

        this.workerPool = new ThreadPoolExecutor(properties.getCorePoolSize(), properties.getMaxPoolSize(), properties.getKeepAliveSeconds(), TimeUnit.SECONDS, new LinkedBlockingQueue<>(properties.getQueueCapacity()), new NamedThreadFactory("eventloop-worker-"), new ThreadPoolExecutor.CallerRunsPolicy());

    }


    private void runEventLoop() {

        while (running.get()) {
            try {
//                final Runnable task = taskQueue.poll(properties.getPollTimeout(), TimeUnit.MILLISECONDS);
//                if (Objects.nonNull(task)) {
//                    submitToWorker(task);
//                }

            } catch (Exception e) {
                Thread.currentThread().interrupt();
                break;
            }
        }

    }

    // 提交任务
    private void submitToWorker(Runnable task) {
        ThreadPoolExecutor executor = (ThreadPoolExecutor) workerPool;

        // 动态 判断线程池状态
        if (executor.getActiveCount() < executor.getMaximumPoolSize() || executor.getQueue().remainingCapacity() > 0) {
            executor.execute(task);
        } else {
            // 线程池满了，直接提交到任务队列
            // taskQueue.offer(task);

            // 降级策略：直接在当前线程执行任务
            // 这种方式可能会导致性能下降，因为当前线程可能会被其他任务占用
            // 但在高并发场景下，这种方式可能更适合
            // 因为高并发场景下，线程池的线程可能会被大量占用，导致任务队列满了
            // 这种情况下，在当前线程执行任务能够保证任务正常执行
            task.run();
        }
    }

    // 对外暴露任务提交接口
    public void submit(Runnable task) {
        if (!taskQueue.offer(task)) {
            throw new RejectedExecutionException("Task queue is full");
        }
    }


    //监控指标：  获取待执行的任务
    public int getPendingTask() {
        return taskQueue.size();
    }

    public int getActiveWorker() {
        return ((ThreadPoolExecutor) workerPool).getActiveCount();
    }


    @Override
    public void start() {
        if (running.compareAndSet(Boolean.FALSE, Boolean.TRUE)) {
            // 定义循环事件线程
            eventLoopThread = new Thread(this::runEventLoop);
            // 设置为守护线程
            eventLoopThread.setDaemon(Boolean.TRUE);
            eventLoopThread.start();
        }
    }

    @Override
    public void stop() {
        running.set(Boolean.FALSE);
        workerPool.shutdown();
        eventLoopThread.interrupt();
    }

    @Override
    public boolean isRunning() {
        return running.get();
    }
}
