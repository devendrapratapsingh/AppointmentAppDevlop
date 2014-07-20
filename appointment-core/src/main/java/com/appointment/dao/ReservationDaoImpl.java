package com.appointment.dao;

import org.bson.types.ObjectId;
import org.springframework.stereotype.Repository;

import com.appointment.domain.Reservation;
@Repository("reservationDao")
public class ReservationDaoImpl extends AbstractBaseDao implements BaseDao<Reservation>{
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	

	public Reservation selectByPk(ObjectId id) {
		// TODO Auto-generated method stub
		return mongoTemplate.findById(id, Reservation.class);
	}

	public ObjectId insert(Reservation reservation) {
		mongoTemplate.insert(reservation);
		return reservation.getId();
	}

	@Override
	public ObjectId update(Reservation entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Reservation entity) {
		// TODO Auto-generated method stub
	}

}
