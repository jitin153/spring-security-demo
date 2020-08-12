package com.demospringsecurity.jwt;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.demospringsecurity.dao.ServiceDao;
import com.demospringsecurity.model.UserBO;

@Service
public class JwtCustomUserDetailsService implements UserDetailsService {

	@Autowired
	private ServiceDao serviceDao;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserBO user = serviceDao.getUserDetails(username);
		if (Objects.isNull(user)) {
			throw new UsernameNotFoundException(String.format("USER_NOT_FOUND '%s'.", username));
		}
		return new JwtCustomUserDetails(user);
	}

}
