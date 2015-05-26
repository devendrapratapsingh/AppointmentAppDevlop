package com.appointment.services;

import java.util.List;

import org.apache.log4j.Logger;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appointment.bo.ResourceTypeBO;
import com.appointment.domain.ResourceType;

@Service("resourceTypeService")
public class ResourceTypeServiceImpl implements ResourceTypeService {

	private static final Logger logger = Logger
			.getLogger(ResourceTypeServiceImpl.class);
	@Autowired
	private ResourceTypeBO baseBO;

	@Override
	public ResourceType add(ResourceType entity) {
		return baseBO.add(entity);
	}

	@Override
	public ResourceType get(ObjectId id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResourceType modify(ResourceType entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ResourceType> getAll(Class<ResourceType> entityClass) {

		return baseBO.getAll(entityClass);
	}

	@Override
	public Long countAll(Class<ResourceType> entityClass) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void remove(ResourceType entity, Class<ResourceType> entityClass) {
		// TODO Auto-generated method stub

	}

}
