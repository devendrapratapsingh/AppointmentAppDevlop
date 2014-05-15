package com.un.services;

import org.bson.types.ObjectId;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.un.domain.Registration;


@Component 
public interface RegistrationService <T>{

	public ObjectId add(T registration);

	public T get(ObjectId id);
}
