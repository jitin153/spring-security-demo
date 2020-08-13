package com.demospringsecurity.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

	@GetMapping("/auth/admin/welcome") // --Should be accessible by admin only.
	public String adminWelcome() {
		return "Welcome admin...";
	}
	
	@GetMapping("/auth/welcome") // --Should be accessible by only user and admin.
	public String userWelcome() {
		return "Welcome user or admin...";
	}

	@GetMapping("/welcome") // --Should be accessible by anyone. No login required.
	public String welcome() {
		return "Welcome...";
	}
}
