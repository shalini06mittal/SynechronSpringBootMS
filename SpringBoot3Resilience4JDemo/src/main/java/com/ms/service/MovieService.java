package com.ms.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import com.ms.client.MovieApiClient;
import com.ms.entity.Movie;
import com.ms.exception.MovieNotFoundException;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.Retry.EventPublisher;
import io.github.resilience4j.retry.RetryRegistry;
import io.github.resilience4j.retry.annotation.Retry;
import jakarta.annotation.PostConstruct;

@Service
public class MovieService {


	private final Logger log = LoggerFactory.getLogger(MovieService.class);
	@Autowired
	private MovieApiClient movieApiClient;


	@Autowired
	private RetryRegistry retryRegistry;

	@Retry(name="simpleRetry")
	@CircuitBreaker(name="greetingClientCB", fallbackMethod = "serviceFallbackMethod")
	public Movie getMovieDetails(String movieId) {
		return fetchMovieDetails(movieId);
	}
	private Movie serviceFallbackMethod(String movieId, Throwable e) {
		log.info("Fallback method called "+e.getMessage());
		return new Movie("CB", "N/A", "N/A", 0.0);
	}

	@Retry(name = "retryOnException")
	public Movie getMovieDetailsOnRetryForException(String id) {
		return fetchMovieDetails(id);
	}

	@Retry(name = "retryWithEventDetails")
	public Movie getMovieDetailsWithRetryEventDetails(String movieId) {
		return fetchMovieDetails(movieId);
	}

	@Retry(name = "simpleRetry", fallbackMethod = "getMovieDetailsFallbackMethod")
	public Movie getMovieDetailsWithFallback(String movieId) {
		return fetchMovieDetails(movieId);
	}

	private Movie getMovieDetailsFallbackMethod(String movieId, MovieNotFoundException e) {
		log.info("Fallback method called");
		return new Movie("Dummy", "N/A", "N/A", 0.0);
	}
	@Retry(name = "customRetryConfig")
	public Movie getMovieDetailsWithCustomRetryConfig(String movieId) {
		return fetchMovieDetails(movieId);
	}

	@Retry(name = "retryBasedOnConditionalPredicate")
	public Movie getMovieDetailsRetryOnConditionalPredicate(String movieId) {
		try {
			return fetchMovieDetails(movieId);
		} catch (MovieNotFoundException movieNotFoundException) {
			log.info("Movie not found exception encountered. Returning default value");
			return new Movie("5", "N/A", "N/A", 0.0);
		}
	}

	@Retry(name = "retryBasedOnExceptionPredicate")
	public Movie getMovieDetailsRetryOnExceptionPredicate(String movieId) {
		return fetchMovieDetails(movieId);
	}

	@Retry(name = "retryUsingExponentialBackoff")
	public Movie getMovieDetailsRetryUsingExponentialBackoff(String movieId) {
		return fetchMovieDetails(movieId);
	}

	@Retry(name = "retryUsingRandomizedWait")
	public Movie getMovieDetailsRetryUsingRandomizedWait(String movieId) {
		return fetchMovieDetails(movieId);
	}
	
	@Retry(name = "custom")
	//@CircuitBreaker(name="greetingClientCB", fallbackMethod = "serviceFallbackMethod")
	public Movie getMovieDetailsUsingCustomRetry(String movieId) {
		return fetchMovieDetails(movieId);
	}

	
	
	private Movie fetchMovieDetails(String movieId) {
		Movie movie = null;


		try {
			movie = movieApiClient.getMovieDetails(movieId);
		}
		catch(HttpClientErrorException e) {
			log.error("Http Client error while fetching details "+e.getMessage());
			throw e;
		}
		catch(Exception e) {
			log.error("Unexpected error while fecthing details");
			//e.printStackTrace();
			System.out.println(e.getMessage());
			throw e;
		}
		return movie;

	}

	@PostConstruct
	public void postConstructEvents() {
		System.out.println("post construct");
		EventPublisher eventPublisher = retryRegistry.retry("retryWithEventDetails").getEventPublisher();
		eventPublisher.onRetry(event -> System.out.println("SImple Retry : On RETRY : Event Details "+event));
		eventPublisher.onError(event -> System.out.println("SImple Retry : On ERROR : Event Details "+event));
		eventPublisher.onEvent(event -> System.out.println("Simple Retry - On Event. Event Details: " + event));
		eventPublisher.onSuccess(event -> System.out.println("Simple Retry - On Success. Event Details: " + event));
		eventPublisher.onIgnoredError(event -> System.out.println("Simple Retry - On Ignored Error. Event Details: " + event));
	}


}
