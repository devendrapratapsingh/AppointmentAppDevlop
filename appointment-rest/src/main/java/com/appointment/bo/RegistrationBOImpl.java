package com.appointment.bo;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.appointment.dao.BaseDao;
import com.appointment.domain.Registration;

@Component
public class RegistrationBOImpl extends AbstractBaseBO<Registration> {

	
	private static final long serialVersionUID = 1L;

	private static final Logger logger = Logger
			.getLogger(RegistrationBOImpl.class);

	@Autowired
	private BaseDao<Registration> baseDao;
		
	@Override
	public Registration modify(Registration entity) {

		logger.debug("Update instance");
		return baseDao.update(entity);
		
	}
	

}
