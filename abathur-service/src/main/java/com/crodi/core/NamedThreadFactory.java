package com.crodi.core;

import org.springframework.lang.NonNull;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Crodi
 * @date 2025/4/14 16:28
 * @description: TODO
 */
public class NamedThreadFactory implements ThreadFactory {

    private final String namePrefix;

    private final AtomicInteger counter = new AtomicInteger(1);


    public NamedThreadFactory(final String namePrefix) {
        this.namePrefix = namePrefix;
    }


    @Override
    public Thread newThread(@NonNull Runnable r) {
        final Thread thread = new Thread(r, namePrefix + counter.getAndIncrement());
        thread.setDaemon(Boolean.TRUE);
        return thread;
    }
}
