package com.dyl.selfViewResolver;

import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.View;

/**
 * 自定义视图渲染器,并使用@component将其纳入到IOC容器中
 * @author Administrator
 *
 */
@Component
public class MySelfView implements View {

	@Override
	public String getContentType() {
		return null;
	}

	//渲染视图
	@Override
	public void render(Map<String, ?> model, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		response.getWriter().print("hello world!"+new Date());
	}

}
