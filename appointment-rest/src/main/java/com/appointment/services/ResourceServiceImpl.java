package com.appointment.services;

import java.util.List;

import org.apache.log4j.Logger;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appointment.bo.ResourceBO;
import com.appointment.domain.Resource;

@Service("resourceService")
public class ResourceServiceImpl implements ResourceService {

	private static final Logger logger = Logger
			.getLogger(ResourceServiceImpl.class);
	@Autowired
	private ResourceBO baseBO;

	@Override
	public Resource add(Resource entity) {
		return baseBO.add(entity);
	}

	@Override
	public Resource get(ObjectId id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Resource modify(Resource entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Resource> getAll(Class<Resource> entityClass) {

		return baseBO.getAll(entityClass);
	}

	@Override
	public Long countAll(Class<Resource> entityClass) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void remove(Resource entity, Class<Resource> entityClass) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Resource> getAllResourcesByType(String type) {
		return baseBO.getAllResourcesByType(type);
	}

	@Override
	public List<Resource> getAllResourcesByTypeNDept(String type,
			String department) {
		return baseBO.getAllResourcesByTypeNDept(type, department);
	}

}
