package com.ms;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingControllerImpl implements GreetingController {
 
    @Override
    public String greeting(@PathVariable("username") String username) {
    	if(username.equals("user"))
    		throw new RuntimeException("invalid username");
        return String.format("Hey, Welcome to circuit breaker concepts %s!\n", username);
    }

}
