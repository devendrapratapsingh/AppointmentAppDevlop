package com.appointment.dao;

import org.bson.types.ObjectId;
import org.springframework.stereotype.Repository;

import com.appointment.domain.Schedule;

/**
 * @author Parag Shrivastava
 * 
 */
@Repository("scheduleDao")
public class ScheduleDaoImpl extends AbstractBaseDao implements BaseDao<Schedule> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Schedule selectByPk(ObjectId id) {
		// TODO Auto-generated method stub
		return (Schedule) mongoTemplate.findById(id, Schedule.class);
	}

	public ObjectId insert(Schedule schedule) {
		// TODO Auto-generated method stub
		mongoTemplate.insert(schedule);
		return schedule.getId();
	}

}
