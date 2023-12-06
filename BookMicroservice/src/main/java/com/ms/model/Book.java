package com.ms.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Book {

	@Id
	private int bookid;
	private String title;
	private double price;
	private String description;
	private String author;
	
	
}
