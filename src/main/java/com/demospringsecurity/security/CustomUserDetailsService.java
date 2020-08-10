package com.demospringsecurity.security;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.demospringsecurity.dao.ServiceDao;
import com.demospringsecurity.model.UserBO;

@Service("customUserDetailsService")
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	private ServiceDao serviceDao;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserBO user = serviceDao.getUserDetails(username);
		if (Objects.isNull(user)) {
			throw new UsernameNotFoundException(String.format("USER_NOT_FOUND '%s'.", username));
		}
		//String[] roles=(String[])user.getRoles().toArray();
		//System.out.println("Role : "+Arrays.toString(roles));
		//UserBuilder userBuilder = org.springframework.security.core.userdetails.User.withUsername(user.getEmail()).password(user.getPassword());//.roles((String[])user.getRoles().toArray());
		//UserDetails user1 = userBuilder.build();
		//System.out.println("Username: " + user1.getUsername() + "\nPassword: " + user1.getPassword());
		//System.out.println("Username: " + user1.getUsername() + "\nPassword: " + user1.getPassword() + "\nRoles: " + user1.getAuthorities().toString());
		//return user1;
		//return new customUserDetails(user);
		List<SimpleGrantedAuthority> roles = user.getRoles().stream().map(role->new SimpleGrantedAuthority(role)).collect(Collectors.toList());
		User userDetails = new User(user.getEmail(),user.getPassword(),roles);
		return userDetails;
	}

}
