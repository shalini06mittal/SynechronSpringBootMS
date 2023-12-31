package com.ms.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ms.model.Book;

public interface BookRepository extends JpaRepository<Book	, Integer>{

	public Book findByTitle(String title);

}

