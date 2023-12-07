package com.techgatha.cb.HystrixCircuitBreakerDemo.service;


import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class MyService {

	@HystrixCommand(fallbackMethod = "defaultDoSomething",
			commandProperties = { 
					@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "30000"),
					@HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "2"),
					@HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "500"), 
					@HystrixProperty(name = "metrics.rollingStats.timeInMilliseconds", value = "180000") }, 
								threadPoolProperties = { @HystrixProperty(name = "coreSize", value = "30"), 
					@HystrixProperty(name = "metrics.rollingStats.timeInMilliseconds", value = "180000") })
	public void doSomething(int input) {
		// ms2
		System.out.println("input: " + input);
		//in case of exception fallbackMethod is called
		System.out.println("output: " + 10 / input); // 0
	}

	public void defaultDoSomething(int input) {
		System.out.println("in default method, the input number: " + input);
	}

	//    @HystrixCommand(fallbackMethod = "defaultDoSomething",commandKey = "mykey")
	//    public void doSomething2(int input) {
	//        try {
	//            TimeUnit.MILLISECONDS.sleep(1500);// timeout scenario
	//        } catch (InterruptedException e) {
	//            return;
	//        }
	//        System.out.println("input: " + input);
	//        System.out.println("output: " + 10 / input);
	//    }
}
