package com.spring.SpringCoreDemo.payment;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

//@Component
//@Lazy
public class Email implements Notification{

	public Email() {
		System.out.println("Email constructor");
	}
	@Override
	public void sendNotification() {
		// TODO Auto-generated method stub
		System.out.println("message sent by email");
	}
	public void display() {
		System.out.println("email display");
	}
}
