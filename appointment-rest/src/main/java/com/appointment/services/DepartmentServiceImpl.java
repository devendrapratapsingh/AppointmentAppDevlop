package com.appointment.services;

import java.util.List;

import org.apache.log4j.Logger;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appointment.bo.BaseBO;
import com.appointment.domain.Department;

@Service("departmentService")
public class DepartmentServiceImpl implements DepartmentService {

	private static final Logger logger = Logger
			.getLogger(DepartmentServiceImpl.class);
	@Autowired
	private BaseBO<Department> baseBO;

	@Override
	public Department add(Department entity) {
		return baseBO.add(entity);
	}

	@Override
	public Department get(ObjectId id) {

		return baseBO.get(id, Department.class);
	}

	@Override
	public Department modify(Department entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Department> getAll(Class<Department> entityClass) {
		return baseBO.getAll(Department.class);
	}

	@Override
	public Long countAll(Class<Department> entityClass) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void remove(Department entity, Class<Department> entityClass) {
		// TODO Auto-generated method stub

	}

}
