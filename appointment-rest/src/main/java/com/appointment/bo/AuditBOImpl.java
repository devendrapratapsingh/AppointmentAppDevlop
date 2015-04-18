package com.appointment.bo;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.appointment.dao.BaseDao;
import com.appointment.domain.Audit;
import com.appointment.domain.Schedule;

@Component
public class AuditBOImpl extends AbstractBaseBO<Audit> {

	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(AuditBOImpl.class);
	@Autowired
	private BaseDao<Audit> baseDao;

	@Override
	public Audit modify(Audit entity) {

		logger.debug("Update instance");
		return baseDao.update(entity);
		
	}	
}
