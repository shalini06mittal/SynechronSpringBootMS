package com.ms.rest;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ms.dto.ResponseDTO;
import com.ms.entity.BookOrder;
import com.ms.repo.BookOrderRepository;

@RestController
@RequestMapping("/orders")
public class BookOrderRestController {
	
	@Autowired
	private BookOrderRepository bookOrderRepository;

	@GetMapping("/{email}")
	public List<BookOrder> getAllOrderBy(
			@RequestHeader(name = "first-request") String firstHeader,
			@PathVariable(name="email") String email)
	{
		System.out.println("header "+firstHeader);
		List<BookOrder> list= this.bookOrderRepository.findAllByEmail(email);
		Set<String> set = new HashSet();
		return this.bookOrderRepository.findAllByEmail(email);
	}
	
	@GetMapping("/wrapper/{email}")
	public ResponseEntity<ResponseDTO> getAllOrderListAndSetBy(@PathVariable(name="email") String email)
	{
		List<BookOrder> list= this.bookOrderRepository.findAllByEmail(email);
		Set<String> set = new HashSet();
		set.add("wishlist");
		set.add("favorites");
		ResponseDTO dto = new ResponseDTO();
		dto.setBookOrders(list);
		dto.setSet(set);
		return ResponseEntity.ok(dto);
	}
}


