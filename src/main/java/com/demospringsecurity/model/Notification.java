package com.demospringsecurity.model;

public class Notification {
	private Long id;
	private String notification;

	public Notification() {
	}

	public Notification(Long id, String notification) {
		this.id = id;
		this.notification = notification;
	}
}
