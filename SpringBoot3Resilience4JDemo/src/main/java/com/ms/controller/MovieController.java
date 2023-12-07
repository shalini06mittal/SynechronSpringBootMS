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

	private final Logger log = LoggerFactory.getLogger(MovieController.class);
	
	
	@Autowired
	private MovieService movieService;
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getMovieById(@PathVariable String id, 
			@RequestParam(required = false, defaultValue = "simpleRetry") String retryType)
	{
		System.out.println(retryType);
		Movie movie = null;
		switch(retryType) {
		case "simpleRetry":
			log.info("Simple retry example");
			movie = movieService.getMovieDetailsWithFallback(id); //getMovieDetails(id);
			return ResponseEntity.ok(movie);
		case "retryOnException":
			log.info("Retry on exception example");
			movie = movieService.getMovieDetailsOnRetryForException(id);
			return ResponseEntity.ok(movie);
		case "retry-on-exception-predicate": {
            log.info("Retry on exception predicate example");
             movie = movieService.getMovieDetailsRetryOnExceptionPredicate(id);
            return ResponseEntity.ok(movie);
        }
        case "retry-on-conditional-predicate": {
            log.info("Retry on conditional predicate example");
             movie = movieService.getMovieDetailsRetryOnConditionalPredicate(id);
            return ResponseEntity.ok(movie);
        }
        case "retry-using-exponential-backoff": {
            log.info("Retry using exponential backoff example");
             movie = movieService.getMovieDetailsRetryUsingExponentialBackoff(id);
            return ResponseEntity.ok(movie);
        }
        case "retry-using-randomized-wait": {
        	// 2000 - 2000 * 0.7 and  2000 + 2000 * 0.7 
            log.info("Retry using randomized wait example");
             movie = movieService.getMovieDetailsRetryUsingRandomizedWait(id);
            return ResponseEntity.ok(movie);
        }
        case "retry-with-fallback": {
            log.info("Retry with fallback example");
             movie = movieService.getMovieDetailsWithFallback(id);
            return ResponseEntity.ok(movie);
        }
        case "retry-with-custom-config": {
            log.info("Retry with custom config example");
             movie = movieService.getMovieDetailsWithCustomRetryConfig(id);
            return ResponseEntity.ok(movie);
        }
        case "retry-with-event-details": {
            log.info("Retry with event details example");
             movie = movieService.getMovieDetailsWithRetryEventDetails(id);
            return ResponseEntity.ok(movie);
        }
        case "custom":
        	log.info("Retry with custom example");
            movie = movieService.getMovieDetailsUsingCustomRetry(id);
           return ResponseEntity.ok(movie);
		}
		return ResponseEntity.ok("Error");
		
	}
}
