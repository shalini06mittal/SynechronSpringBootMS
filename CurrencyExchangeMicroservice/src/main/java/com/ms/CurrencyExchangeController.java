package com.ms;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.ms.model.ConversionBean;

@RestController
public class CurrencyExchangeController {

	@Autowired
	private RestTemplate template;
	
	@GetMapping("/exchange/{from}/{to}/{qty}")
	public ConversionBean getExchangeValue(
			@PathVariable(name="from") String from, 
			@PathVariable(name="to") String to, 
			@PathVariable(name="qty") int qty) {
		
		ConversionBean bean =  template.getForObject("http://FOREX-SERVICE/forex-exchange/from/{from}/to/{to}", ConversionBean.class,
				from, to);
		bean.setQuantity(new BigDecimal(qty));
		return bean;
	}
}
