package com.zero.web;


import com.zero.model.User;
import com.zero.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {
	
	@Autowired
	private UserRepository userRepository;
	
	@RequestMapping("/getUsers")
	public List<User> getUsers() {
		List<User> users=userRepository.findAll();
		return users;
	}


    
}