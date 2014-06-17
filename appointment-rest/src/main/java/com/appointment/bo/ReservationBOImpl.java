package com.appointment.bo;

import org.apache.log4j.Logger;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.appointment.dao.BaseDao;
import com.appointment.domain.Reservation;
@Component
public class ReservationBOImpl extends AbstractBaseBO implements IBaseBO<Reservation>{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(ReservationBOImpl.class);
	@Autowired
	private BaseDao<Reservation> baseDao;

	public ObjectId add(Reservation reservation) {
		logger.debug("Add Reservation instance");
		return baseDao.insert(reservation);
	}

	public Reservation get(ObjectId id) {
		logger.debug("Get Reservation instance stored");
		return baseDao.selectByPk(id);
	}

}
