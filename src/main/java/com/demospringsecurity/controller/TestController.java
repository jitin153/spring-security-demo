package com.demospringsecurity.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demospringsecurity.model.Message;
import com.demospringsecurity.model.Notification;
import com.demospringsecurity.model.User;

@RestController
//@RequestMapping("/api")
public class TestController {

	//@RolesAllowed({"USER","ADMIN"})
	@GetMapping("/auth/welcome") //--Should be accessible by only user and admin.
	public String userWelcome() {
		return "Welcome user...";
	}
	
	//@RolesAllowed("ADMIN")
	@GetMapping("/auth/admin/welcome") //--Should be accessible by admin only.
	public String adminWelcome() {
		return "Welcome admin...";
	}
	
	
	@GetMapping("/welcome") //--Should be accessible by anyone. No login required.
	public String welcome() {
		return "Welcome...";
	}
	
	@GetMapping("/home") //--Should be accessible by anyone. No login required.
	public String home() {
		return "Welcome...";
	}
	
	@GetMapping("/about") //--Should be accessible by anyone. No login required.
	public String about() {
		return "Welcome...";
	}
	
	@GetMapping("/about/contactus") //--Should be accessible by anyone. No login required.
	public String contactus() {
		return "Welcome...";
	}
	
	@PostMapping("/auth/admin/user") //--Should be accessible by anyone. No login required.
	public String user(@RequestBody User user) {
		return "Welcome admin...";
	}
	
	@PostMapping("/auth/message") //--Should be accessible by anyone. No login required.
	public String message(@RequestBody Message message) {
		return "Welcome user...";
	}
	
	@PostMapping("/notification") //--Should be accessible by anyone. No login required.
	public String notificatio(@RequestBody Notification notificatio) {
		return "Welcome...";
	}
}
