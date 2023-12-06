package com.ms.bean;

import java.time.LocalDate;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class BookOrderBean {

	private int bookid;
	private int qty;
	private LocalDate orderdate;
}
