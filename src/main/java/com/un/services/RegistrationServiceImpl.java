package com.un.services;


import org.apache.log4j.Logger;
import org.bson.types.ObjectId;

import com.un.dao.BaseDao;
import com.un.domain.Registration;

public class RegistrationServiceImpl implements RegistrationService<Registration> {

	private static final Logger logger = Logger
			.getLogger(RegistrationServiceImpl.class);
	private BaseDao dao;

	public BaseDao getDao() {
		return dao;
	}

	public void setDao(BaseDao dao) {
		this.dao = dao;
	}


	public ObjectId add(Registration registration) {
		logger.debug("Adding a new LogItem instance");
		return dao.insert(registration);
	}

	public Registration get(ObjectId id) {
		return (Registration) dao.selectByPk(id);
	}

}
