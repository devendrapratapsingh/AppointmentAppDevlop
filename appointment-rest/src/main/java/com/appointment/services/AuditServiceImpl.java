package com.appointment.services;

import org.apache.log4j.Logger;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appointment.bo.IBaseBO;
import com.appointment.domain.Audit;

@Service("auditService")
public class AuditServiceImpl implements AuditService<Audit> {
	
	private static final Logger logger = Logger.getLogger(AuditServiceImpl.class);
	@Autowired
	private IBaseBO<Audit> baseBO;	

	/**
	 * @return the baseBO
	 */
	public IBaseBO<Audit> getBaseBO() {
		return baseBO;
	}

	/**
	 * @param baseBO the baseBO to set
	 */
	public void setBaseBO(IBaseBO<Audit> baseBO) {
		this.baseBO = baseBO;
	}

	public ObjectId addAudit(Audit audit) {
		logger.debug("Adding Audit class instance");
		return baseBO.add(audit);
	}

	public Audit get(ObjectId id) {
		logger.debug("Getting stored Audit class instance");
		return baseBO.get(id);
	}

}
