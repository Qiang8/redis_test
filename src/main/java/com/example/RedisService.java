package com.example;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.BoundHashOperations;
import org.springframework.data.redis.core.BoundValueOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import com.example.domain.User;

@Service
public class RedisService {
	
	@Autowired
	RedisTemplate redisTemplate;
	
	@Autowired
	StringRedisTemplate stringRedisTemplate;

	public void test(User user) {
		String uuid=UUID.randomUUID().toString();
		/*stringRedisTemplate.opsForValue().set(uuid, "测试", 800);
		redisTemplate.opsForValue().set(uuid, "测试",1000);
		Map<String,String>map=new HashMap<>();
		map.put("name", "Dalunt");
		map.put("age", "22");
		map.put("qq", "12345");
		redisTemplate.opsForHash().putAll("user:002", map);
		stringRedisTemplate.opsForHash().putAll("user:5", map);*/

		Map<String,Object>map=new HashMap<>();
		map.put("userName", user.getUserName());
		map.put("email", user.getEmail());
		map.put("id", Integer.toString(user.getId()));
		stringRedisTemplate.opsForHash().putAll("user:005", map);
				
		//return "aa";
	}
	
	public List<Object> getUser() {
		  BoundHashOperations<String, Object, Object> boundHashOps = stringRedisTemplate.boundHashOps("user:005");
		  List<Object> values = boundHashOps.values();
		  return values;
		
	}
}
