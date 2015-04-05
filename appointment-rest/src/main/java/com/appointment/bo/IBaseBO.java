package com.appointment.bo;

import org.bson.types.ObjectId;

public interface IBaseBO<T> {

	public T add(T registration);

	public T get(ObjectId id);
}
