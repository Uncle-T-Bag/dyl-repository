package com.dyl.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dyl.entity.Department;
import com.dyl.entity.Employee;
import com.dyl.repository.DepartmentRepository;
import com.dyl.repository.EmployeeRepository;

@Controller
@RequestMapping("/test")
public class TestController {

	@Autowired private DepartmentRepository dr;
	
	//@requestBody
	@RequestMapping("/testFileUpload")
	@ResponseBody
	public String testFileUpload(@RequestBody String body){
		System.out.println(body);
		return "helloworld!"+new Date();
	}
	
	//JSON
	@RequestMapping("/testJSON")
	@ResponseBody
	public List<Department> testJson(){
		return dr.findAll();
	}
	
	//国际化
	@RequestMapping("/i18n")
	public String testi18n(){
		return "i18n";
	}
	
	//自定义的BeanNameViewResolver
	@RequestMapping("/beanNameViewResolver")
	public String testBeanNameViewResolver(){
		System.out.println("Test BeanNameViewResolver...");
		return "mySelfView";
	}
	
	//测试自定义的String-Date的类型转换器
	@RequestMapping(value="/testDateConverter",method=RequestMethod.POST)
	public String testMyConverter(@RequestParam(value="dateStr") Date dateStr){
		System.out.println(dateStr);
		return "redirect:/";
	}
}
