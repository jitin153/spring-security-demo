package com.demospringsecurity.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser("Jitin").password(passwordEncoder.encode("123")).roles("ADMIN");
		auth.inMemoryAuthentication().withUser("Vipin").password(passwordEncoder.encode("123")).roles("ADMIN");
		auth.inMemoryAuthentication().withUser("Aniket").password(passwordEncoder.encode("123")).roles("USER");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable().authorizeRequests().antMatchers("/auth/admin/**").hasRole("ADMIN")
		.antMatchers("/auth/**").hasAnyRole("ADMIN", "USER")// .anyRequest().authenticated()
		.antMatchers("/").permitAll()
				// .anyRequest().permitAll()
				// .antMatchers("/").permitAll()
				.and().httpBasic();//.formLogin();
	}

	@Bean
	public PasswordEncoder getPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
}