package com.un.services;

import org.apache.log4j.Logger;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.un.bo.IBaseBO;
import com.un.domain.Schedule;

/**
 * @author Parag Shrivastava
 * 
 */
@Service("scheduleService")
public class ScheduleServiceImpl implements ScheduleService<Schedule> {

	private static final Logger logger = Logger
			.getLogger(ScheduleServiceImpl.class);

	@Autowired
	private IBaseBO<Schedule> iBaseBO;

	public ObjectId addSchedule(Schedule schedule) {
		// TODO Auto-generated method stub
		logger.debug("This is add Schedule entity menthod");
		return iBaseBO.add(schedule);
	}

	public Schedule get(ObjectId id) {
		// TODO Auto-generated method stub
		logger.debug("This is get Schedule entity method");
		return iBaseBO.get(id);
	}

	/**
	 * @return the iBaseBO
	 */
	public IBaseBO<Schedule> getiBaseBO() {
		return iBaseBO;
	}

	/**
	 * @param iBaseBO
	 *            the iBaseBO to set
	 */
	public void setiBaseBO(IBaseBO<Schedule> iBaseBO) {
		this.iBaseBO = iBaseBO;
	}

}
