package com.rest.api.model;

import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="books")
public class Book {
	
	@Id
	@GeneratedValue
	private Long id;
	
	private String book_name;
	private String author_name;
	private String isbn;
	
	public Book() {
		super();
	}
	
	public Book(Long id, String book_name, String author_name, String isbn) {
		super();
		this.id = id;
		this.book_name = book_name;
		this.author_name = author_name;
		this.isbn = isbn;
	}

	public Long getId() {
		return id;
	}

	public String getBook_name() {
		return book_name;
	}

	public void setBook_name(String book_name) {
		this.book_name = book_name;
	}

	public String getAuthor_name() {
		return author_name;
	}

	public void setAuthor_name(String author_name) {
		this.author_name = author_name;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book other = (Book) obj;
		return Objects.equals(id, other.id);
	}

}
