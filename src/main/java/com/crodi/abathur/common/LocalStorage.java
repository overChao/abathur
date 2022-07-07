package com.crodi.abathur.common;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * author: zkc
 * date: 2022/2/28 10:49
 * description: LocaluserStorage
 * version: 1.0
 */

@Component
public class LocalStorage {

	static Cache<String, Object> cache =
			CacheBuilder.newBuilder()
					.maximumSize(100)
					.expireAfterAccess(10, TimeUnit.MINUTES)
					.build();


	// 从本地缓存中获取用户信息
	public static Object getUserInfo(String token) {
		return cache.getIfPresent(token);
	}

	// 添加用户缓存
	public static void addLoginUser(String token) {
		// 调用用户服务  getUserByToken 获取用户信息
		cache.put(token,"");
	}


}
