package com.ms.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.ms.bean.BookResponseBean;

@FeignClient(name="BOOK-SERVICE")
public interface BookServiceFeignClient {
	
	@GetMapping("/books/{id}")
	public BookResponseBean getBookById(@PathVariable int id);

}
