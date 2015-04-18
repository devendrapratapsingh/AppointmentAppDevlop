package com.appointment.dao;

import org.bson.types.ObjectId;
import org.springframework.beans.BeanUtils;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.appointment.domain.Registration;

@Repository("regDao")
public class RegistrationDaoImpl extends AbstractBaseDao<Registration> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public Registration update(Registration entity) {

		Query queryRegistrationUpdate = new Query();
		ObjectId objId = entity.getId();
		queryRegistrationUpdate.addCriteria(Criteria.where("id").is(objId));
		Registration storedRegistration = mongoTemplate.findOne(queryRegistrationUpdate,
				Registration.class);
		entity.setId(storedRegistration.getId());
		BeanUtils.copyProperties(entity, storedRegistration);
		mongoTemplate.save(storedRegistration);
		return entity;
	}

}
