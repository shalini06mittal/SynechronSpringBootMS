package com.ms.config;

import java.time.Duration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.HttpClientErrorException;

import com.ms.exception.MovieNotFoundException;

import io.github.resilience4j.retry.Retry;
import io.github.resilience4j.retry.RetryConfig;
import io.github.resilience4j.retry.RetryRegistry;

@Configuration
public class RetryCustomConfiguration {

	@Autowired 
	private RetryRegistry registry;
	
	@Bean
	Retry retryWithCustomConfiguration()
	{
		System.out.println("custom config");
		RetryConfig custom = RetryConfig.custom()
				.maxAttempts(4)
				.waitDuration(Duration.ofSeconds(1))
				
//				.retryExceptions(HttpClientErrorException.class)
//				.ignoreExceptions(MovieNotFoundException.class)
				.build();
		
		return registry.retry("custom", custom);
	}
}
