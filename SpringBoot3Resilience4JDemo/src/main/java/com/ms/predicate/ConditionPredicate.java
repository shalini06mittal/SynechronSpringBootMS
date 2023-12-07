package com.ms.predicate;

import java.util.function.Predicate;

import com.ms.entity.Movie;

public class ConditionPredicate implements Predicate<Movie>{

	@Override
	public boolean test(Movie t) {
		System.out.println("Condition predicate is called");
		return t.getId().equals("5");
	}

}
