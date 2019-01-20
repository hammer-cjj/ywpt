package com.zsga.ywpt.service;

import com.zsga.ywpt.pojo.User;

public interface UserService {
	//根据用户名和密码查找用户
	User get(String username, String password);
}
