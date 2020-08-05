package com.demospringsecurity.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

@Service("testService")
public class TestServiceImpl implements TestService{

	@Override
	public List<String> getNotification() {
		return Arrays.asList("Not_1","Not_2");
	}

}
