package com.dyl.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dyl.entity.Employee;
import com.dyl.services.DepartmentService;
import com.dyl.services.EmployeeService;

@Controller
@RequestMapping("/emp")
public class EmployeeController {

	@Autowired private EmployeeService es;
	@Autowired private DepartmentService ds;
	//字符串到date类型的转换
	@InitBinder  
	public void initBinder(WebDataBinder binder) {  
	    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");  
	    dateFormat.setLenient(false);  
	    binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
	}
	//使用ModelAttribute将对象放至在作用域中，它会在目标方法调用之前被调用
	@ModelAttribute
	public void getEmployee(@RequestParam(value="id",required=false) Integer id,
			Map<String, Object> map){
		if(id!=null){
			Employee employee = es.get(id);
			//设置成null,使关联对象为一个新的对象，这样才能完成修改操作
			employee.setDepartment(null);
			map.put("employee", employee);
		}
	}
	
	@RequestMapping(value="/del/{id}",method=RequestMethod.DELETE)
	public String delEmployee(@PathVariable("id")Integer id){
		es.delete(id);
		return "redirect:/emp/list";
	}
	
	@RequestMapping(value="/add/{id}",method=RequestMethod.PUT)
	public String editEmployee(Employee employee){
		es.save(employee);
		return "redirect:/emp/list";
	}
	
	@RequestMapping(value="/edit/{id}",method=RequestMethod.GET)
	public String editEmployee(@PathVariable("id")Integer id,Map<String, Object> map){
		map.put("employee", es.get(id));
		map.put("depts", ds.getAll());
		return "dept_add";
	}
	
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public String addEmployee(Employee employee){
		es.save(employee);
		return "redirect:/emp/list";
	}
	
	@RequestMapping(value="/validateLName",method=RequestMethod.POST)
	@ResponseBody
	public String ajaxValidateLoginName(@RequestParam(value="lName",required=true) String lName){
		Employee emp = es.getByLName(lName);
		if(emp == null){
			return "0";
		}else {
			return "1";
		}
	}
	
	@RequestMapping("/list")
	public String listEmp(@RequestParam(name="pageNo",required=false,defaultValue="1") String pageNoStr,
						  Map<String, Object> map){
		int pageNo = 1;
		try {
			pageNo = Integer.parseInt(pageNoStr);
			if(pageNo<0){
				pageNo = 1;
			}
		} catch (Exception e) {}
		Page<Employee> page = es.getPage(pageNo, 5);
		map.put("page", page);
		return "emp_list";
	}
}
