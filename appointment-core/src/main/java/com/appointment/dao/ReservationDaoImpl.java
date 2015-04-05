package com.appointment.dao;

import org.bson.types.ObjectId;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.appointment.domain.Reservation;

@Repository("reservationDao")
public class ReservationDaoImpl extends AbstractBaseDao<Reservation> implements
		BaseDao<Reservation> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public Reservation update(Reservation entity) {
		ApplicationContext ctx = new GenericXmlApplicationContext(
				"spring-config.xml");

		MongoOperations mongoOperation = (MongoOperations) ctx
				.getBean("mongoTemplate");

		Query searchUserQuery = new Query(Criteria.where("id").is(
				entity.getId().toString()));

		mongoOperation.remove(searchUserQuery, Reservation.class);

		entity.setId(new ObjectId());

		mongoOperation.save(entity);

		return entity;
	}

}
