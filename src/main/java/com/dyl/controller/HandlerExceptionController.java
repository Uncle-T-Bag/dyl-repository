package com.dyl.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

/**
 * @ControllerAdvice注解标记异常处理类
 */
@ControllerAdvice
public class HandlerExceptionController {

	//标记异常处理方法
	@ExceptionHandler({NullPointerException.class})
	public ModelAndView handlerExceptions(Exception e){
		//使用ModelAndView将异常传递到View层
		ModelAndView mv = new ModelAndView("error");
		mv.addObject("exception", e);
		return mv;
	}
}
