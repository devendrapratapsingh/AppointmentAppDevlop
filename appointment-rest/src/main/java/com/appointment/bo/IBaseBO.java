package com.appointment.bo;

import org.bson.types.ObjectId;
public interface IBaseBO<T> {

	public ObjectId add(T registration);

	public T get(ObjectId id);
}
