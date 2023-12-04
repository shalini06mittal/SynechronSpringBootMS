package com.spring.SpringCoreDemo.payment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.payment.PaymentProject.PaymentService;

@Component
public class Invoice {
	/*
	 * Invoice has a dependency on the object of type Notification?
	 * 1. constructor injection
	 * 2. setter injection
	 * 3. field
	 */
	@Autowired
	@Qualifier("sms")
	Notification notification;
	
	@Autowired
	PaymentService paymentService;
	
	public Invoice() {
		System.out.println("Invoice default constructor");
	}
	
	//@Autowired
	public Invoice(Notification notification) {
		super();
		System.out.println("Invoice parameterized constructor");
		this.notification = notification;
	}

	public Notification getNotification() {
		return notification;
	}
	//@Autowired
	public void setNotification(Notification notification) {
		System.out.println("Invoice setter constructor");
		this.notification = notification;
	}

	public void processOrder() {
		System.out.println("processing order");
		notification.sendNotification();
		System.out.println(paymentService.makePayment(10000, 10));
	}
	

}
