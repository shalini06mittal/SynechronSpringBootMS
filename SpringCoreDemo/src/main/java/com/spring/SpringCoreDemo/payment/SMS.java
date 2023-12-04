package com.spring.SpringCoreDemo.payment;

import org.springframework.stereotype.Component;

@Component("sms")
public class SMS implements Notification{

	@Override
	public void sendNotification() {
		// TODO Auto-generated method stub
		System.out.println("sending message by sms");
	}
}
