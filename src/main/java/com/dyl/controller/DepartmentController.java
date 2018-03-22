package com.dyl.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.dyl.entity.Employee;
import com.dyl.services.DepartmentService;

@Controller
@RequestMapping("/dept")
public class DepartmentController {

	@Autowired private DepartmentService ds;
	
	@RequestMapping(value="/add",method=RequestMethod.GET)
	public String addDept(Map<String, Object> map){
		map.put("depts", ds.getAll());
		map.put("employee",new Employee());
		return "dept_add";
	}
}
