package com.ms.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookOrder {
	
	@Id
	private int orderid;
	private String email;
	private int bookid;
	private LocalDate orderdate;
	private int qty;
	private String deladdress;
	
}
