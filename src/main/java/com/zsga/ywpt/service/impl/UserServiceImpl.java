package com.zsga.ywpt.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zsga.ywpt.mapper.UserMapper;
import com.zsga.ywpt.pojo.User;
import com.zsga.ywpt.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper userMapper;
	
	//根据用户名和密码查找用户
	@Override
	public User get(String username, String password) {
		User user  = new User(username, password);
		User result = userMapper.get(user);
		return result;
	}

}
