package com.book.service;

import java.util.List;

import com.book.repository.BookRepository;
import com.crudrepository.CrudRepository;
import com.main.Book;

public class BookService  {
	
	private CrudRepository<Book> bookList;
	
	public BookService() {
		super();
		this.bookList = new BookRepository();
	}

	public Book add(Book t) {
		return this.bookList.add(t);
		
	}
	public List<Book> findAll(){
		return this.bookList.findAll();
	}

}
