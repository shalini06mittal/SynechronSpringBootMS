package com.techgatha;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;

//@Component
public  class GreetingClientFallback implements GreetingClient {
    @Override
    public String greeting(@PathVariable("username") String username) {
        return "Hello Guest!";
    }
}
