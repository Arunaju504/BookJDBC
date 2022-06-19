package com.book.repository;

import java.util.ArrayList;
import java.util.List;

import com.crudrepository.CrudRepository;
import com.main.Book;

public class BookRepository implements CrudRepository<Book> {

	private List<Book> bookList;
	
	public BookRepository() {
		super();
		this.bookList=new ArrayList<>();
	}

	@Override
	public Book add(Book t) {
boolean isAdded = this.bookList.add(t);
if(isAdded) {
	return t;
}else {
	return null;
}

		
	}

	@Override
	public List<Book> findAll() {
		// TODO Auto-generated method stub
		return this.bookList;
	}

}
