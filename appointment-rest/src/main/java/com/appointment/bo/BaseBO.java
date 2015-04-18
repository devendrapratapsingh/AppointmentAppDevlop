package com.appointment.bo;

import java.util.List;

import org.bson.types.ObjectId;

public interface BaseBO<T> {

	public T add(T entity);

	public T get(ObjectId id,  Class<T> entityClass);
	
	public T modify(T entity);

	public List<T> getAll(Class<T> entityClass);

	public Long countAll(Class<T> entityClass);

	void remove(T entity, Class<T> entityClass);
}
