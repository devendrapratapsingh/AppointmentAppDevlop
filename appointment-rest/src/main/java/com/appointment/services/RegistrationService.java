package com.appointment.services;

import org.bson.types.ObjectId;


public interface RegistrationService <T>{

	public ObjectId add(T registration);

	public T get(ObjectId id);
}
