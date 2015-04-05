package com.appointment.dao;

import org.bson.types.ObjectId;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.appointment.domain.Schedule;

/**
 * @author Parag Shrivastava
 * 
 */
@Repository("scheduleDao")
public class ScheduleDaoImpl extends AbstractBaseDao<Schedule> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public Schedule update(Schedule entity) {

		ApplicationContext ctx = new GenericXmlApplicationContext(
				"spring-config.xml");

		MongoOperations mongoOperation = (MongoOperations) ctx
				.getBean("mongoTemplate");

		Query searchUserQuery = new Query(Criteria.where("id").is(
				entity.getId().toString()));

		mongoOperation.remove(searchUserQuery, Schedule.class);

		entity.setId(new ObjectId());

		mongoOperation.save(entity);

		return entity;
	}

}
