package com.ms.predicate;

import java.util.function.Predicate;

import com.ms.entity.Movie;
import com.ms.exception.MovieNotFoundException;

public class ExceptionPredicate implements Predicate<Throwable>{

	@Override
	public boolean test(Throwable t) {
		System.out.println("Exception predicate is called");
		return t instanceof MovieNotFoundException;
	}

}
