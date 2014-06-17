package com.appointment.dao;

import org.bson.types.ObjectId;
import org.springframework.stereotype.Repository;

import com.appointment.domain.Audit;

@Repository("auditDao")
public class AuditDaoImpl extends AbstractBaseDao implements BaseDao<Audit>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Audit selectByPk(ObjectId id) {
		// TODO Auto-generated method stub
		return mongoTemplate.findById(id, Audit.class);
	}

	public ObjectId insert(Audit audit) {
		mongoTemplate.save(audit);
		return audit.getId();
	}

}
