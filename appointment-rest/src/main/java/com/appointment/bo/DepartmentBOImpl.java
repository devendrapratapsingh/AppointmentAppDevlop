package com.appointment.bo;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.appointment.dao.BaseDao;
import com.appointment.domain.Department;

@Component
public class DepartmentBOImpl extends AbstractBaseBO<Department> implements
		DepartmentBO {

	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger
			.getLogger(ReservationBOImpl.class);
	@Autowired
	private BaseDao<Department> baseDao;

	@Override
	public Department modify(Department entity) {
		// TODO Auto-generated method stub
		return null;
	}

}
