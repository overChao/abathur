package com.crodi.abathur.core;

import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.function.Consumer;
import java.util.function.Function;

/**
 * @author Crodi
 * @date 2025/4/24 16:43
 * @description:
 * 线程执行器
 */
public interface AsyncExecutor {

    /**
     * 无参任务
     *
     * @param task 异步任务
     */
    void execute(Runnable task);

    /**
     * 有参任务
     *
     * @param task  异步任务
     * @param param 任务参数
     * @param <T>   参数类型
     */
    <T> void execute(Consumer<T> task, T param);


    /**
     * 提交有返回值任务
     *
     * @param task 任务
     * @param <T>  返回值类型
     * @return 执行结果
     */
    <T> Future<T> submit(Callable<T> task);


    /**
     * 提交有参有返回值任务
     *
     * @param task  任务
     * @param param 任务参数
     * @param <T>   参数类型
     * @param <R>   响应类型
     * @return 执行结果
     */
    <T, R> Future<R> submit(Function<T, R> task, T param);

}
