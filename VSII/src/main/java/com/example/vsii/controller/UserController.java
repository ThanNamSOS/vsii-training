package com.example.vsii.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.vsii.Repository.UserRepository;
import com.example.vsii.model.User;
import com.example.vsii.utils.HttpUtil;


@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserRepository userRepository;
	
	@PostMapping("add")
	public void addUser(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("applicaton/json");
		User user =  HttpUtil.of(request.getReader()).toModel(User.class);
		userRepository.save(user);
	}
}
