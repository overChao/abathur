package com.crodi.core;

import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Component;

import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;

import java.util.function.Consumer;
import java.util.function.Function;

/**
 * @author Crodi
 * @date 2025/5/20 10:54
 * @description: 定义任务异步执行器
 */

@Component
public class TaskExecutor implements AsyncExecutor {

    private final Executor executor;

    public TaskExecutor(Executor defaultTaskExecutor) {
        this.executor = defaultTaskExecutor;
    }


    @Override
    public void execute(Runnable task) {
        executor.execute(task);
    }

    @Override
    public <T> void execute(Consumer<T> task, T param) {
        executor.execute(() -> task.accept(param));
    }

    @Override
    public <T> Future<T> submit(Callable<T> task) {
        return ((ThreadPoolTaskExecutor) executor).submit(task);
    }

    @Override
    public <T, R> Future<R> submit(Function<T, R> task, T param) {
        return ((ThreadPoolTaskExecutor) executor).submit(() -> task.apply(param));
    }
}
