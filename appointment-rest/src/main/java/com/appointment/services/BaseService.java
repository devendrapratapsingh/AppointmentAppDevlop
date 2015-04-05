package com.appointment.services;

import org.bson.types.ObjectId;

public interface BaseService<T> {

	public T add(T t);

	public T get(ObjectId id);

}
