package com.demospringsecurity.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.demospringsecurity.service.TestService;


@RestController
public class MyTestControllerImpl implements MyTestController{

	@Autowired
	private TestService testService;
	
	@Override
	public List<String> getNotification() {
		return testService.getNotification();
	}

}
