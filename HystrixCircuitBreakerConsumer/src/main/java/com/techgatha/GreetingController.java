package com.techgatha;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {
 
//    @Autowired
//    private GreetingService greetingService;
// 
//    @GetMapping("/get-greeting/{username}")
//    public String getGreeting(Model model, @PathVariable("username") String username) {
//        return greetingService.getGreeting(username);
//        
//    }
	
    @Autowired
    private GreetingClient greetingService;
 
    @GetMapping("/get-greeting/{username}")
    public String getGreeting( @PathVariable("username") String username) {
        return greetingService.greeting(username);
        
    }

}
