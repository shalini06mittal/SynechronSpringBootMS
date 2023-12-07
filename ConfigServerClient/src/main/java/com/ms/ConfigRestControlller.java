package com.ms;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


// http://localhost:8080/actuator/refresh ->POST request
// https://www.appsdeveloperblog.com/spring-cloud-bus-refreshing-config-changes/
// https://medium.com/swlh/spring-cloud-config-bus-auto-refresh-properties-for-clients-d18fa4c036cb#:~:text=Every%20Config%20Client%20(application%20service,properties%20will%20be%20re%2Dfetched.
@RestController
@RequestMapping("/config")
@RefreshScope
public class ConfigRestControlller {

	@Value("${msg:Config not working}")
	private String message;
	
	@GetMapping
	public String sendMessage() {
		return message;
	}
}
