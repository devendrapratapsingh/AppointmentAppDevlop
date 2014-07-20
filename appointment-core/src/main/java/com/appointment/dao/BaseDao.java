package com.appointment.dao;

import org.bson.types.ObjectId;

public interface BaseDao<T> {

	T selectByPk(ObjectId id);

	ObjectId insert(T entity);
	
	ObjectId update(T entity);
	
	void delete(T entity);
}
