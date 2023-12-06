package com.ms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.ms.model.ForexExcchange;
import com.ms.repository.ForexExchangeRepository;

@RestController
public class ForexController {

	@Autowired
	ForexExchangeRepository repository;
	
	public ForexController() {
		System.out.println("controller");
	}

    @GetMapping("/forex-exchange/from/{from}/to/{to}")
    public ForexExcchange retrieveExchangeValue
            (@PathVariable(name="from") String from, 
            		@PathVariable(name="to") String to){

    	System.out.println(repository.count());
    	ForexExcchange exchangeValue =
                repository.findByFromAndTo(from, to);

        return exchangeValue;
    }
    
    @GetMapping("/from/{from}/to/{to}")
    public String greet(@PathVariable(name = "from") String from, 
    		@PathVariable(name="to") String to)
    {
    	return "hey "+from + " "+to;
    }
    

}

