package com.dyl.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dyl.entity.Department;
import com.dyl.repository.DepartmentRepository;

@Service
public class DepartmentService {

	@Autowired DepartmentRepository dr ;
	
	@Transactional(readOnly=true)
	public List<Department> getAll(){
		return dr.getAll();
	}
	
}
