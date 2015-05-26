package com.appointment.dao;

import org.springframework.stereotype.Repository;

import com.appointment.domain.Department;

@Repository("departmentDao")
public class DepartmentDaoImpl extends AbstractBaseDao<Department> implements
		DepartmentDao {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public Department update(Department entity) {
		// TODO Auto-generated method stub
		return null;
	}

}
