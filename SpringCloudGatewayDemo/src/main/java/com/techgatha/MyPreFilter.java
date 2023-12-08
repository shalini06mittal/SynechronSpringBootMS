package com.techgatha;

import java.time.LocalTime;

import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.stereotype.Component;

import reactor.core.publisher.Mono;

@Component
public class MyPreFilter extends AbstractGatewayFilterFactory<MyPreFilter.Config> {
	
	public MyPreFilter() {
		super(Config.class);
	}
	
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
		System.out.println("inside pre filter ");
		System.out.println("name "+config.getName());
		return (exchange, chain) -> {
			System.out.println("First pre filter" + exchange.getRequest());
			System.out.println("pre "+LocalTime.now());
			//Custom Post Filter.Suppose we can call error response handler based on error code.
			return chain.filter(exchange).then(Mono.fromRunnable(() -> {
				System.out.println("First post filter "+LocalTime.now());
			}));
		};
//		return (exchange, chain)->{
//			ServerHttpRequest req = exchange.getRequest().mutate().header("pre-header", Math.random()*10+" ").build();
//			return chain.filter(exchange.mutate().request(req).build());
//		};
	}

}
