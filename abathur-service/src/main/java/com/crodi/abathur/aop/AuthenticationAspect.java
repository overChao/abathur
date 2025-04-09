package com.crodi.abathur.aop;


import com.crodi.abathur.LocalStorage;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;


import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * author: zkc
 * date: 2022/2/25 18:10
 * description: AuthenticationAspect
 * version: 1.0
 */

@Aspect
@Component
public class AuthenticationAspect {

	@Pointcut(value = "@annotation(com.crodi.abathur.aop.Authentication)")
	public void pointcut(){}


	@Before(value = "@annotation(com.crodi.abathur.aop.Authentication)")
	public void before(JoinPoint joinPoint){
		for (Object arg : joinPoint.getArgs()) {
			if (arg instanceof HttpServletRequest){
				HttpServletRequest request = (HttpServletRequest) arg;
				Map<String, String[]> parameterMap = request.getParameterMap();
				String token = request.getHeader("token");
				if (token != null) {
					// 从 LocalStorage 获取用户信息  LocalStorage 通过 guava cache 实现
					Object userInfo = LocalStorage.getUserInfo(token);
					if (userInfo != null) {

					}
				}
				return;
			}
		}
	}

}
