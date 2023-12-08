package com.ms.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Schema(description = "This is a book model")
public class Book {

	@Id
	@NotBlank
	@Schema(description = "Id to access a book", example = "1, 2, 3")
	private int bookid;
	private String title;
	@Size(min=1)
	private double price;
	private String description;
	@NotNull
	private String author;
	
	
}
