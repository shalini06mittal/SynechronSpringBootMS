package com.techgatha;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class GreetingService {
	
	@Autowired
	private RestTemplate template;
	
    @HystrixCommand(fallbackMethod = "defaultGreeting")
    public String getGreeting(String username) {
        return template
          .getForObject("http://HYSTRIX-PRODUCER/greeting/{username}", 
          String.class, username);
    }
 
    private String defaultGreeting(String username) {
        return "Hello User!";
    }
}
