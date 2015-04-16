package com.appointment.services;

import java.util.List;

import org.bson.types.ObjectId;

public interface BaseService<T> {

	public T add(T entity);

	public T get(ObjectId id);
	
	public T modify(T entity);

	public List<T> getAll(Class<T> entityClass);

	public Long countAll(Class<T> entityClass);

	void remove(T entity, Class<T> entityClass);

}
