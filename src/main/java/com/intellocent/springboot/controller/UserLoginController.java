package com.intellocent.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserLoginController {

	@GetMapping("/showMyLoginPage")
	public String showMyLoginPage() {
		return "user-login";
	}

}
