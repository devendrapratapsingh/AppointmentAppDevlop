package com.appointment.services;

import java.util.List;

import org.apache.log4j.Logger;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appointment.bo.BaseBO;
import com.appointment.domain.Audit;

@Service("auditService")
public class AuditServiceImpl implements BaseService<Audit> {

	private static final Logger logger = Logger
			.getLogger(AuditServiceImpl.class);
	@Autowired
	private BaseBO<Audit> baseBO;

	@Override
	public Audit get(ObjectId id) {
		logger.debug("Getting a stored Audit instance");
		Audit Audit = baseBO.get(id, Audit.class);
		return Audit;
	}
	@Override
	public Audit add(Audit aud) {
		logger.debug("Adding a new Audit instance");
		Audit Audit = baseBO.add(aud);
		return Audit;
	}
	
	@Override
	public List<Audit> getAll(Class<Audit> entityClass) {
		logger.debug("Getting all the Audits");
		List<Audit> fetched = baseBO.getAll(Audit.class);
		return fetched;
	}
	@Override
	public Long countAll(Class<Audit> entityClass) {
		logger.debug("Counting the Audits");
		long recordCount = baseBO.countAll(Audit.class);
		return recordCount;
	}
	
	@Override
	public void remove(Audit entity, Class<Audit> entityClass) {
		logger.debug("Implementation not required");
		}
	
	@Override
	public Audit modify(Audit aud) {
		logger.debug("Implementation not required");
		return null;
	}


}
