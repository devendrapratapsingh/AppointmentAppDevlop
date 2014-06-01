package com.un.services;

import org.bson.types.ObjectId;

public interface AuditService<T> {
	
    public ObjectId addAudit( T audit);
	
	public T get(ObjectId id);


}
