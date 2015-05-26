package com.appointment.bo;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.appointment.dao.ResourceDao;
import com.appointment.domain.Resource;

@Component
public class ResourceBOImpl extends AbstractBaseBO<Resource> implements
		ResourceBO {

	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger
			.getLogger(ReservationBOImpl.class);
	@Autowired
	private ResourceDao baseDao;

	@Override
	public Resource modify(Resource entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Resource> getAllResourcesByType(String type) {
		return baseDao.getAllResourcesByType(type);
	}

	@Override
	public List<Resource> getAllResourcesByTypeNDept(String type,
			String department) {
		return baseDao.getAllResourcesByTypeNDept(type, department);
	}

}
