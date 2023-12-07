package com.techgatha;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "HYSTRIX-PRODUCER", fallback=GreetingClient.GreetingClientFallback1.class)
public interface GreetingClient  {
   
		@GetMapping("/greeting/{username}")
        public String greeting(@PathVariable("username") String username) ;
    
		@Component
		static class GreetingClientFallback1 implements GreetingClient {
		    @Override
		    public String greeting(@PathVariable("username") String username) {
		        return "Hello Guest From Feign!";
		    }
		}
}

