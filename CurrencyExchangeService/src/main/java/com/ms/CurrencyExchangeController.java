package com.ms;

import java.math.BigDecimal;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.ms.model.ConversionBean;

@RestController
public class CurrencyExchangeController {

	/**
	 * 
	 * 1. manual creation of Rest Template object
	 * 2. http://localhost:8000 => hardcoded urls
	 * 3. dynamic url => unique id http://forex-service [ 5 instances : 80 81 82 83 84 ]
	 * 4. creating the url and passing the values for the placeholder
	 * 
	 * MS terms
	 * 1. discoverable
	 * 2. load balancers => client side, server side
	 * 3. server
	 * 4. monitor the status of the services
	 * 
	 * Eureka server
	 */
	@GetMapping("/exchange/{from}/{to}/{qty}")
	public ConversionBean getExchangeValue(
			@PathVariable(name="from") String from, 
			@PathVariable(name="to") String to, 
			@PathVariable(name="qty") int qty) {
		
		RestTemplate template = new RestTemplate();
		ConversionBean bean =  template.getForObject("http://localhost:8000/forex-exchange/from/{from}/to/{to}", ConversionBean.class,
				from, to);
		bean.setQuantity(new BigDecimal(qty));
		return bean;
	}
}
