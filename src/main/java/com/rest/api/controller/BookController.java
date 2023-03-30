package com.rest.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.rest.api.exception.BookNotFoundException;
import com.rest.api.model.Book;
import com.rest.api.repository.BookRepository;

@RestController
public class BookController {

	@Autowired
	BookRepository bookRepository;
	
	@GetMapping("/books")
	public List<Book> getAllNotes() {
		return bookRepository.findAll();
	}

	
	@PostMapping("/books")
	public Book createNote(@RequestBody Book book) {
		return bookRepository.save(book);
	}
	
	
	@GetMapping("/books/{id}")
	public Book getNoteById(@PathVariable(value = "id") Long bookId) throws BookNotFoundException {
		return bookRepository.findById(bookId)
				.orElseThrow(() -> new BookNotFoundException(bookId));
	}
	
	
	@PutMapping("/books/{id}")
	public Book updateNote(@PathVariable(value = "id") Long bookId, @RequestBody Book bookDetails) throws BookNotFoundException {
		Book book = bookRepository.findById(bookId)
				.orElseThrow(() -> new BookNotFoundException(bookId));
		
		book.setBook_name(bookDetails.getBook_name());
		book.setAuthor_name(bookDetails.getAuthor_name());
		book.setIsbn(bookDetails.getIsbn());
		
		Book updateBook = bookRepository.save(book);
		
		return updateBook;	
	}
	
	
	@DeleteMapping("/books/{id}")
	public ResponseEntity<?> deleteBook(@PathVariable(value = "id") Long bookId) throws BookNotFoundException {
		Book book = bookRepository.findById(bookId)
				.orElseThrow(() -> new BookNotFoundException(bookId));
		
		bookRepository.delete(book);
		
		return ResponseEntity.ok().build();
	}
}
