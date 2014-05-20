package com.un.services;

import org.bson.types.ObjectId;

public interface ScheduleService <T> {

	public ObjectId addSchedule( T schedule);
	
	public T get(ObjectId id);
}
