package com.appointment.bo;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.appointment.dao.BaseDao;
import com.appointment.domain.ResourceType;

@Component
public class ResourceTypeBOImpl extends AbstractBaseBO<ResourceType> implements
		ResourceTypeBO {

	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger
			.getLogger(ReservationBOImpl.class);
	@Autowired
	private BaseDao<ResourceType> baseDao;

	@Override
	public ResourceType modify(ResourceType entity) {
		// TODO Auto-generated method stub
		return null;
	}

}
