package com.appointment.bo;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.appointment.dao.BaseDao;
import com.appointment.domain.Schedule;

@Component
public class ScheduleBOImpl extends AbstractBaseBO<Schedule>  {

	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(ScheduleBOImpl.class);
	@Autowired
	private BaseDao<Schedule> baseDao;

	@Override
	public Schedule modify(Schedule entity) {

		logger.debug("Update instance");
		return baseDao.update(entity);
		
	}	

}
