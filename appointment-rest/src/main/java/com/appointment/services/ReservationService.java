package com.appointment.services;

import org.bson.types.ObjectId;

public interface ReservationService <T>  {

	public ObjectId add(T reservation);

	public T get(ObjectId id);
}
