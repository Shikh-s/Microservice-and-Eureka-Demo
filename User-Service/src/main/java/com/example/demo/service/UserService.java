package com.example.demo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.demo.pojo.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.vo.Department;
import com.example.demo.vo.ResponseTemplateVo;
@Service
public class UserService {

	@Autowired
	UserRepository userRepository;
	
	@Autowired
	RestTemplate restTemplate;
	
	public User addUser(User user) {
		
		return userRepository.save(user);
	}
	public ResponseTemplateVo getUserWithDepartment(int userId) {
		 Optional<User> optional=userRepository.findById(userId);
		 User user=optional.get();
		 Department department =restTemplate.getForObject("http://localhost:9002/departments/"+user.getDepartmentId(), Department.class);
		 ResponseTemplateVo vo=new ResponseTemplateVo();
		 vo.setDepartment(department);
		 vo.setUser(user);
		 
		 return vo;
	}

}
