package com.ms.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ms.entity.BookOrder;

public interface BookOrderRepository extends JpaRepository<BookOrder, Integer> {

	public List<BookOrder> findAllByEmail(String email);
}
