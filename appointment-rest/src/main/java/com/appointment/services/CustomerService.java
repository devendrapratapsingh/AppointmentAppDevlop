package com.appointment.services;

import org.bson.types.ObjectId;

public interface CustomerService <T> {
	
    public ObjectId addCustomer( T customer);
	
	public T get(ObjectId id);

}
