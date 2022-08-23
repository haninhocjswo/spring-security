package com.cos.security1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cos.security1.model.User;
import com.cos.security1.repository.UserRepository;

@Controller
public class IndexController {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@GetMapping({"/",""})
	public String index() {
		return "index";
	}
	
	@GetMapping("/user")
	@ResponseBody
	public String user() {
		return "user";
	}
	
	@GetMapping("/manager")
	@ResponseBody
	public String manager() {
		return "manager";
	}
	
	@GetMapping("/admin")
	@ResponseBody
	public String admin() {
		return "admin";
	}
	
	@GetMapping("/loginForm")
	public String loginForm() {
		return "loginForm";
	}	

	@GetMapping("/login")	//Spring Security가 낚아챔 -> SecurityConfig 설정파일 생성 후엔 안 낚아챔
	@ResponseBody
	public String login() {
		return "login";
	}	
	
	@GetMapping("/logout")
	@ResponseBody
	public String logout() {
		return "logout";
	}
	
	@GetMapping("/joinForm")
	public String joinForm() {
		return "joinForm";
	}

	@PostMapping("/join")
	public String join(User user) {
		user.setRole("ROLE_USER");
		String oriPwd = user.getPassword();
		String encPwd = bCryptPasswordEncoder.encode(oriPwd);
		userRepository.save(user);
		return "redirect:/loginForm";
	}
}
