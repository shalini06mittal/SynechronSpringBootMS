package com.ms.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import com.ms.client.MovieApiClient;
import com.ms.entity.Movie;

import io.github.resilience4j.retry.Retry.EventPublisher;
import io.github.resilience4j.retry.RetryRegistry;
import io.github.resilience4j.retry.annotation.Retry;
import jakarta.annotation.PostConstruct;

@Service
public class MovieService {


	private final Logger logger = LoggerFactory.getLogger(MovieService.class);
	@Autowired
	private MovieApiClient movieApiClient;


	@Autowired
	private RetryRegistry retryRegistry;
	
	@Retry(name="simpleRetry")
	public Movie getMovieDetails(String movieId) {
		return fetchMovieDetails(movieId);
	}

	@Retry(name = "retryOnException")
	public Movie getMovieDetailsOnRetryForException(String id) {
		return fetchMovieDetails(id);
	}
	private Movie fetchMovieDetails(String movieId) {
		Movie movie = null;

		
		try {
			movie = movieApiClient.getMovieDetails(movieId);
		}
		catch(HttpClientErrorException e) {
			logger.error("Http Client error while fetching details "+e.getMessage());
			throw e;
		}
		catch(Exception e) {
			logger.error("Unexpected error while fecthing details");
			//e.printStackTrace();
			System.out.println(e.getMessage());
			throw e;
		}
		return movie;

	}
	
	@PostConstruct
	public void postConstructEvents() {
		System.out.println("post construct");
		EventPublisher eventPublisher = retryRegistry.retry("returyWithEventDetails").getEventPublisher();
		eventPublisher.onRetry(event -> System.out.println("SImple Retry : On RETRY : Event Details "+event));
		eventPublisher.onError(event -> System.out.println("SImple Retry : On ERROR : Event Details "+event));
		eventPublisher.onEvent(event -> System.out.println("Simple Retry - On Event. Event Details: " + event));
		eventPublisher.onSuccess(event -> System.out.println("Simple Retry - On Success. Event Details: " + event));
        eventPublisher.onIgnoredError(event -> System.out.println("Simple Retry - On Ignored Error. Event Details: " + event));
	}

	
}
