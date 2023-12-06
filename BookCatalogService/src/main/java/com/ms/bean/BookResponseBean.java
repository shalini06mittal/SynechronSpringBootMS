package com.ms.bean;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class BookResponseBean {

	private String title;
	private String author;
	private double price;
	private LocalDate orderdate;
	private int qty;
}
