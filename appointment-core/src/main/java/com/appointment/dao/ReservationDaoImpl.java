package com.appointment.dao;

import org.bson.types.ObjectId;
import org.springframework.beans.BeanUtils;
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
		Query queryReservationUpdate = new Query();
		ObjectId objId = entity.getId();
		queryReservationUpdate.addCriteria(Criteria.where("id").is(objId));
		Reservation storedReservation = mongoTemplate.findOne(queryReservationUpdate,
				Reservation.class);
		entity.setId(storedReservation.getId());
		BeanUtils.copyProperties(entity, storedReservation);
		mongoTemplate.save(storedReservation);
		return entity;
	}

}
