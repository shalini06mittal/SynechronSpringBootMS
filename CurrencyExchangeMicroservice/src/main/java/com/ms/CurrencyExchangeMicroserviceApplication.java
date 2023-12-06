package com.ms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class CurrencyExchangeMicroserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CurrencyExchangeMicroserviceApplication.class, args);
	}

	@Bean
	@LoadBalanced
	 RestTemplate template()
	{
		return new RestTemplate();
	}
}
