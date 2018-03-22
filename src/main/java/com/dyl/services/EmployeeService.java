package com.dyl.services;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dyl.entity.Employee;
import com.dyl.repository.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository er;
	
	@Transactional
	public void updOrDel(String lName,Integer id){
		er.updOrDelMethdo(lName, id);
	}
	
	@Transactional(readOnly=true)
	public Employee get(Integer id){
		return er.findOne(id);
	}
	
	@Transactional
	public void delete(Integer id){
		er.delete(id);
	}
	
	@Transactional
	public void save(Employee employee){
		if(employee.getId()==null){
			employee.setCreateTime(new Date());
		}
		employee.setUpdateTime(new Date());
		//saveAndFlush相当于jpa中的merge()方法
		er.saveAndFlush(employee);
	}
	
	@Transactional(readOnly=true)
	public Employee getByLName(String lName){
		return er.getByLName(lName);
	};
	
	@Transactional(readOnly=true)
	public Page<Employee> getPage(int pageNo, int pageSize){
		//PageRequest是Pageable的唯一实现类
		PageRequest pageable = new PageRequest(pageNo-1, pageSize);
		return er.findAll(pageable);
	}
}
