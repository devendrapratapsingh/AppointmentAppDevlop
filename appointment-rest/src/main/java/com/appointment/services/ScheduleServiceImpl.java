package com.appointment.services;

import org.apache.log4j.Logger;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appointment.bo.IBaseBO;
import com.appointment.domain.Schedule;

/**
 * @author Parag Shrivastava
 * 
 */
@Service("scheduleService")
public class ScheduleServiceImpl implements BaseService<Schedule> {

	private static final Logger logger = Logger
			.getLogger(ScheduleServiceImpl.class);

	@Autowired
	private IBaseBO<Schedule> iBaseBO;

	public Schedule add(Schedule schedule) {
		logger.debug("This is add Schedule entity menthod");
		return iBaseBO.add(schedule);
	}

	public Schedule get(ObjectId id) {
		logger.debug("This is get Schedule entity method");
		return iBaseBO.get(id);
	}

}
