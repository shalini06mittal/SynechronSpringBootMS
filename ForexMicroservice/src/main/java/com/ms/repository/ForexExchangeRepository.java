package com.ms.repository;

import org.springframework.data.repository.CrudRepository;

import com.ms.model.ForexExcchange;

public interface ForexExchangeRepository extends CrudRepository<ForexExcchange, Long>{

	public ForexExcchange findByFromAndTo(String from,String to);
}
