package com.dyl.interceptors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * SpringMVC提供自定义拦截器的扩展
 * 
 */
public class FirstTestInterceptor implements HandlerInterceptor {
	/**
	 * 
	 * return true: 可以调用目标方法和后面的拦截器
	 * return false: 不能调用目标方法和后面的拦截器
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println("FirstTestInterceptor preHandle invoke...");
		return true;
	}
	/**
	 * 调用在目标方法之后，渲染视图之前
	 * 
	 */
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		System.out.println("FirstTestInterceptor postHandle invoke...");
	}
	/**
	 * 渲染视图之后
	 */
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		System.out.println("FirstTestInterceptor afterCompletion invoke...");
	}

}
