package com.techgatha;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@EnableCircuitBreaker
@SpringBootApplication
@EnableFeignClients

public class HystrixCircuitBreakerConsumerApplication {

	public static void main(String[] args) {
		SpringApplication.run(HystrixCircuitBreakerConsumerApplication.class, args);
	}

	
	@Bean
	@LoadBalanced
	public RestTemplate template()
	{
		return new RestTemplate();
	}
}
