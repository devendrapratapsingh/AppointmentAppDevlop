package com.appointment.dao;

import org.bson.types.ObjectId;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

public interface BaseDao<T> {

	T selectByPk(ObjectId id);

	ObjectId insert(T entity);
}
