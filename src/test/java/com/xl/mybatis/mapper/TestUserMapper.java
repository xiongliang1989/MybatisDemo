package com.xl.mybatis.mapper;

import org.junit.Test;

import com.xl.mybatis.entity.User;
import com.xl.mybatis.service.UserServiceImpl;

public class TestUserMapper {

	@Test
	public void test(){
		UserServiceImpl userServiceImpl = new UserServiceImpl();
		User user =new User();
		user.setEmail("test@foxmail.com");
		user.setUsername("test");
		user.setPassword("123456");
		userServiceImpl.insert(user);
		System.out.println(user);
	}
}
