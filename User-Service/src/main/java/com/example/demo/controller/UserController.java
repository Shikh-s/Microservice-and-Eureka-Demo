package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.pojo.User;
import com.example.demo.service.UserService;
import com.example.demo.vo.ResponseTemplateVo;

@RestController
@RequestMapping(path = "/users")
public class UserController {
	
	@Autowired
	UserService userservice;
	
	@PostMapping(path = "/adduser")
	public User addUser(@RequestBody User user) {
		return userservice.addUser(user);
	}
	
	@GetMapping(path = "/getuserwithdepartment/{userid}")
	public ResponseTemplateVo getUserWithDepartment(@PathVariable("userid") int userId) {
		return userservice.getUserWithDepartment(userId);
	}
}
