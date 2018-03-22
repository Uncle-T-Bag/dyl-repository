package com.dyl.converter;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
/**
 * 自定义类型转换器，将页面传递的String类型转为Date类型
 * @author Administrator
 *
 */
@Component
public class DateConverter implements Converter<String, Date> {

	@Override
	public Date convert(String str) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		sdf.setLenient(false);
		Date date = null;
		if(str!=null&&str!=""){
			try {
				date = sdf.parse(str);
				System.out.println(str+"-convert-"+date);
				return date;
			} catch (Exception e) {
				e.printStackTrace();
				throw new RuntimeException("类型转换异常");
			}
		}
		return null;
	}

}
