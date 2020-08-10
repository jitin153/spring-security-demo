package com.demospringsecurity.dao;

import com.demospringsecurity.model.UserBO;

public interface ServiceDao {
	public UserBO getUserDetails(String email);
}
