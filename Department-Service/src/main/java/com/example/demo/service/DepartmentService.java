package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.pojo.Department;
import com.example.demo.repository.Repo;

@Service
public class DepartmentService {

	@Autowired
	Repo repo;
	public Department addDepartment(Department department) {
		return repo.save(department); 
	}
	public Department getDepartment(int deptId) {
		return repo.findById(deptId).get();
	}

}
