package com.techgatha;

import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.stereotype.Component;

import reactor.core.publisher.Mono;

@Component
public class MyGlobalFilter extends AbstractGatewayFilterFactory<MyGlobalFilter.Config> {
	
	
	
	public static class Config{
		private String name;

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}
		
		
	}

	@Override
	public GatewayFilter apply(Config config) {
		System.out.println("inside global filter "+config.getName());
		
		return (exchange, chain) -> {
			System.out.println("First Global filter");
			return chain.filter(exchange).then(Mono.fromRunnable(() -> {
				System.out.println("Second Global filter");
			}));
		};
	}

}
