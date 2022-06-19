package com.crudrepository;

import java.util.List;

public interface CrudRepository<T> {

	public T add(T t);
	public List<T> findAll();
	
}
