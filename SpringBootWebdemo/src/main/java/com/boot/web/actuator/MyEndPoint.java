package com.boot.web.actuator;

import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.stereotype.Component;

@Endpoint(id="custom")
@Component
public class MyEndPoint {

	@ReadOperation
	public String sendMessage() {
		return "from my custom endpoint";
	}
}
