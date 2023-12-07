package com.ms.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ms.entity.Movie;
import com.ms.service.MovieService;

@RestController
@RequestMapping("/movies")
public class MovieController {

	private final Logger logger = LoggerFactory.getLogger(MovieController.class);
	
	
	@Autowired
	private MovieService movieService;
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getMovieById(@PathVariable String id, 
			@RequestParam(required = false, defaultValue = "simpleRetry") String retryType)
	{
		switch(retryType) {
		case "simpleRetry":
			logger.info("Simple retry example");
			Movie movie = movieService.getMovieDetails(id);
			return ResponseEntity.ok(movie);
		}
		return ResponseEntity.ok("Error");
		
	}
}
