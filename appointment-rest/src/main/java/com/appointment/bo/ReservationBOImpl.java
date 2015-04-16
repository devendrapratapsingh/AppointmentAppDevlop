package com.appointment.bo;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.appointment.dao.BaseDao;
import com.appointment.domain.Reservation;

@Component
public class ReservationBOImpl extends AbstractBaseBO<Reservation>  {

	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(ReservationBOImpl.class);
	@Autowired
	private BaseDao<Reservation> baseDao;

	@Override
	public Reservation modify(Reservation entity) {

		logger.debug("Update instance");
		return baseDao.update(entity);
		
	}	

}
