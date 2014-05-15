package com.un.bo;

import org.apache.log4j.Logger;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.un.dao.BaseDao;
import com.un.domain.Registration;
@Component
public class RegistrationBOImpl  extends AbstractBaseBO implements IBaseBO<Registration> {
		
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static final Logger logger = Logger
			.getLogger(RegistrationBOImpl.class);
	
	@Autowired	
	private BaseDao<Registration> dao;

	public BaseDao<Registration> getDao() {
		return dao;
	}

	public void setDao(BaseDao<Registration> dao) {
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
