package com.ms.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.ms.entity.Movie;
import com.ms.exception.MovieNotFoundException;

// javabrains by kaushik 

@Component
public class MovieApiClient {

	@Autowired
	private RestTemplate template;
	
	public Movie getMovieDetails(String movieId) {
	
		String url = "http://localhost:8080/mock/movies/" + movieId;
		Movie movie = template.getForObject(url, Movie.class);
		if(movie == null)
			throw new MovieNotFoundException("Movie with id "+movieId+" not found");
		return movie;
	}
	
}
