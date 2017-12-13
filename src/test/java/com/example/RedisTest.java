package com.example;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.domain.User;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisTest {
	
	@Autowired
	private RedisService redisService;

	@Test
	public void TsetStringRedisTemplate() {
		User user =new User("userName", "email", 2533);
		redisService.test(user);
	}
	
	@Test
	public void getUser() {
		
		List<Object> user = redisService.getUser();
		System.out.println(user);
		
	}
	
	
}
