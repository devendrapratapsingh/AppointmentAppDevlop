package com.appointment.services;

import org.apache.log4j.Logger;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appointment.bo.IBaseBO;
import com.appointment.domain.Reservation;

@Service("reservationService")
public class ReservationServiceImpl implements ReservationService<Reservation>  {
	
	private static final Logger logger = Logger.getLogger(ReservationServiceImpl.class);

	@Autowired
	private IBaseBO<Reservation> baseBO;

	/**
	 * @return the baseBO
	 */
	public IBaseBO<Reservation> getBaseBO() {
		return baseBO;
	}

	/**
	 * @param baseBO the baseBO to set
	 */
	public void setBaseBO(IBaseBO<Reservation> baseBO) {
		this.baseBO = baseBO;
	}

	
	public ObjectId add(Reservation reservation) {
		logger.debug("Adding a new Reservation instance");
		return baseBO.add(reservation);
	}

	public Reservation get(ObjectId id) {
		logger.debug("Getting a stored reservation instance");
		return baseBO.get(id);
	}

}
