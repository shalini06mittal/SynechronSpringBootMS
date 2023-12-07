package com.ms.controller.mock;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ms.entity.Movie;

@RestController
@RequestMapping("/mock/movies")
public class MovieMockController {

	@GetMapping("/{id}")
	public ResponseEntity<?> getMovieByid(@PathVariable(name="id") String id){
		Movie movie = null;
		
		switch(id) {
		case "1":
			movie = new Movie("1", "Matrix", "Lana" , 4);
			break;
		case "2":
			movie = new Movie("2", "Inception", "Christopher" , 5);
			break;
		case "3":
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Movie not found");
		}
		return ResponseEntity.ok(movie);
	}
}
