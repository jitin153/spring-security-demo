package com.demospringsecurity.dao;

import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.demospringsecurity.model.UserBO;

@Service
public class ServiceDao {

	public UserBO getUserDetails(String email) {
		UserBO user = new UserBO();
		if (email.equalsIgnoreCase("narendra@gmail.com")) {
			user.setEmail("narendra@gmail.com");
			user.setFullName("Narendra");
			/*
			 * Password is encrypted. Actual password is : Narendra
			 */
			user.setPassword("$2a$10$IbkLKhDNVTyk0evioojFOu3y5YzpVd9Nh039nyuV1guNZqXEGgwm.");
			Set<String> roles = new HashSet<>();
			roles.add("USER");
			user.setRoles(roles);
		} else if(email.equalsIgnoreCase("jitin@gmail.com")) {
			user.setEmail("jitin@gmail.com");
			user.setFullName("Jitin");
			/*
			 * Password is encrypted. Actual password is : Jitin
			 */
			user.setPassword("$2a$10$UGy5.vjQ59GjGVjokulzi.nsS8tCq4LwKKWurs.sOyU.mQEYSTWt.");
			Set<String> roles = new HashSet<>();
			roles.add("ADMIN");
			user.setRoles(roles);
		}
		return user;
	}

}
