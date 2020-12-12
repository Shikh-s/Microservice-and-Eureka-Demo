package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.pojo.Department;
import com.example.demo.service.DepartmentService;

@RestController
@RequestMapping(path = "/departments")
public class departmentController {

	@Autowired
	DepartmentService departmentService;
	
	@PostMapping(path = "/adddepartment")
	public Department addDepartment(@RequestBody Department department) {
		return departmentService.addDepartment(department);
	}
	
	@GetMapping(path = "/{id}")
	public Department getDepartment(@PathVariable("id") int deptId) {
		return departmentService.getDepartment(deptId);
	}
}
