package com.appointment.bo;

import org.apache.log4j.Logger;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.appointment.dao.BaseDao;
import com.appointment.domain.Audit;
import com.appointment.services.AuditServiceImpl;

@Component
public class AuditBOImpl extends AbstractBaseBO implements IBaseBO<Audit> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static final Logger logger = Logger
			.getLogger(AuditServiceImpl.class);
	@Autowired
	private BaseDao<Audit> baseDao;

	public Audit add(Audit audit) {
		logger.debug("Add audi instance ");
		return baseDao.insert(audit);
	}

	public Audit get(ObjectId id) {
		logger.debug("Get stored audit instance");
		return baseDao.selectByPk(id, Audit.class);
	}

}
