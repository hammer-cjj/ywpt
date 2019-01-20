package com.zsga.ywpt.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.zsga.ywpt.pojo.User;
import com.zsga.ywpt.service.UserService;
import com.zsga.ywpt.util.CommonUtil;

@Controller
@RequestMapping("")
public class UserController {
	@Autowired
	private UserService userService;
	
	@RequestMapping("index")
	public String index() {
		return "login";
	}
	
	@RequestMapping("login")
	public String login(@RequestParam("username")String username,@RequestParam("password") String password, @RequestParam("verifyCodeExpected")String verifyCodeExpected,
			@RequestParam("verifyCodeActual")String verifyCodeActual, Model model, HttpServletRequest request) {
		
		//检查验证码
		if (verifyCodeActual == null || !verifyCodeExpected.equals(CommonUtil.stringUtil(verifyCodeActual))) {
			model.addAttribute("msg", "验证码错误");
			return "login";
		}
		
		User user = userService.get(username, password);
		if (null == user) {
			model.addAttribute("msg", "账号密码错误");
			return "login";
		}
		request.getSession().setAttribute("user", user);
		return "main";
	}
	
	@RequestMapping("logout")
	public String logout(HttpServletRequest request) {
		request.getSession().removeAttribute("user");
		return "redirect:index";
	}
}
