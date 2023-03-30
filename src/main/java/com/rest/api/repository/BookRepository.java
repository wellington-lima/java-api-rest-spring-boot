package com.rest.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rest.api.model.Book;

public interface BookRepository extends JpaRepository<Book, Long>{

}
