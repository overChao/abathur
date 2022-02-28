package com.kechao.crodi.common;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;

import java.util.concurrent.TimeUnit;

/**
 * author: zkc
 * date: 2022/2/28 10:22
 * description: GuavaCacheUtil
 * version: 1.0
 */

public class GuavaCacheUtil {

	static Cache<String, Object> cache;

	public static Cache<String, Object> cache() {

		synchronized (Cache.class) {
			if (cache == null) {
				return CacheBuilder.newBuilder()
						.maximumSize(100)
						.expireAfterWrite(10, TimeUnit.MINUTES)
						.concurrencyLevel(10)
						.build();
			}
			return cache;
		}
	}

}



