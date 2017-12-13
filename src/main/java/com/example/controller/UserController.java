package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.example.RedisService;
import com.example.domain.User;

@Controller
@RequestMapping("/UserController")
public class UserController {
	
	@Autowired
	private RedisService redisService;
	
	@RequestMapping(value="/addUser")
	public String addUser() {
		return "userRegister";
	}
	
	@RequestMapping(value="/register",method=RequestMethod.POST)
	public String resister(User user) {
		System.out.println(user);
		redisService.test(user);
		return "ok";
	}

}
