package com.appointment.dao;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.appointment.domain.Audit;

@Repository("auditDao")
public class AuditDaoImpl extends AbstractBaseDao<Audit> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public Audit update(Audit entity) {

		Query searchUserQuery = new Query(Criteria.where("id").is(
				entity.getId().toString()));

		entity.setId(new ObjectId());

		mongoTemplate.save(entity);

		return entity;

	}

}
