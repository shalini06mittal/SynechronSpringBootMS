package com.ms.feign;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.ms.bean.BookOrderBean;

@FeignClient(name="BOOK-ORDER-SERVICE")
public interface BookOrderServiceFeignClient {
	
	@GetMapping("/orders/{email}")
	public List<BookOrderBean> getAllOrderedBooks(@PathVariable String email);

}
