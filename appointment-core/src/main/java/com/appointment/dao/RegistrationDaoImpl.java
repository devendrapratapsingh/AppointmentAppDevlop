package com.appointment.dao;

import org.apache.log4j.Logger;
import org.bson.types.ObjectId;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.appointment.domain.Registration;

@Repository("regDao")
public class RegistrationDaoImpl extends AbstractBaseDao<Registration> {

	/**
	 * 
	 */
	private static final Logger logger = Logger
			.getLogger(RegistrationDaoImpl.class);

	private static final long serialVersionUID = 1L;

	@Override
	public Registration update(Registration entity) {

		ApplicationContext ctx = new GenericXmlApplicationContext(
				"spring-config.xml");

		MongoOperations mongoOperation = (MongoOperations) ctx
				.getBean("mongoTemplate");

		Query searchUserQuery = new Query(Criteria.where("id").is(
				entity.getId().toString()));

		mongoOperation.remove(searchUserQuery, Registration.class);

		entity.setId(new ObjectId());

		mongoOperation.save(entity);

		return entity;
	}

}
