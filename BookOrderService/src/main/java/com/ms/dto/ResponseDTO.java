package com.ms.dto;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

import com.ms.entity.BookOrder;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseDTO {

	private List<BookOrder> bookOrders;
	private Set<String> set;
	
}
