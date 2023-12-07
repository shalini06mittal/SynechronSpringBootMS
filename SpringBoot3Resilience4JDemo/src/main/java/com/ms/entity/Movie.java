package com.ms.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@AllArgsConstructor
public class Movie {

	private String id;
	private String title;
	private String director;
	private double rating;
}
