package com.un.bo;

import org.apache.log4j.Logger;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.un.dao.BaseDao;
import com.un.domain.Audit;
import com.un.services.AuditServiceImpl;

@Component
public class AuditBOImpl extends AbstractBaseBO implements IBaseBO<Audit> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private static final Logger logger = Logger.getLogger(AuditServiceImpl.class);
	@Autowired
	private BaseDao<Audit> baseDao;

	public ObjectId add(Audit audit) {
		logger.debug("Add audi instance ");
		return baseDao.insert(audit);
	}

	public Audit get(ObjectId id) {
		logger.debug("Get stored audit instance");
		return baseDao.selectByPk(id);
	}

}
