package com.techgatha.cb.HystrixCircuitBreakerDemo;

import com.techgatha.cb.HystrixCircuitBreakerDemo.service.MyService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.concurrent.TimeUnit;


//http://localhost:8080/actuator/hystrix.stream

@SpringBootApplication
@EnableHystrixDashboard
@EnableCircuitBreaker
public class HystrixCircuitBreakerDemoApplication {

	public static void main(String[] args) throws InterruptedException {
		ConfigurableApplicationContext ctx = SpringApplication.run(HystrixCircuitBreakerDemoApplication.class, args);
		MyService myService = ctx.getBean(MyService.class);

		TimeUnit.SECONDS.sleep(10);
		
		System.out.println("-- calling doSomething(1) 40 times --");
		int n = 40;
		for (int i = 0; i < n; i++) {
			System.out.println("******* "+i +" **************");
			myService.doSomething(i < (n * 0.6) ? 0 : 2);
			TimeUnit.MILLISECONDS.sleep(100);
			//if(i==30) TimeUnit.SECONDS.sleep(6);
		}
		TimeUnit.SECONDS.sleep(6);

		System.out.println("-- final call --");
		myService.doSomething(2);
	}

}
