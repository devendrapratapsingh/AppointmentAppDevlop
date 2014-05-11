package com.un.services;

import org.bson.types.ObjectId;

import com.un.domain.Registration;

public interface RegistrationService <T>{

	public ObjectId add(T registration);

	public T get(ObjectId id);
}
