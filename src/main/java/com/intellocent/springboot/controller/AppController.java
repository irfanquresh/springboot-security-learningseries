package com.intellocent.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AppController {

	@GetMapping("/")
	public String showHomePage() {
		return "home";
	}

	@GetMapping("/leaders")
	public String showLeaderPage() {
		return "leader";
	}

	@GetMapping("/system")
	public String showSystemPage() {
		return "system";
	}
}
