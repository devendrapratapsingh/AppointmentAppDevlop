package com.un.bo;

import org.apache.log4j.Logger;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Component;

import com.un.dao.BaseDao;
import com.un.domain.Schedule;

/**
 * @author Parag Shrivastava
 *
 */
@Component
public class ScheduleBOImpl extends AbstractBaseBO implements IBaseBO<Schedule>{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private static final Logger logger = Logger.getLogger(ScheduleBOImpl.class);
	
	private BaseDao<Schedule> baseDao;

	
	public ObjectId add(Schedule schedule) {
		logger.debug("This is add schedule entity method");
		// TODO Auto-generated method stub
		return baseDao.insert(schedule);
	}

	public Schedule get(ObjectId id) {
		logger.debug("This is get Schedule entity by ObjectId method");
		// TODO Auto-generated method stub
		return (Schedule) baseDao.selectByPk(id);
	}

	/**
	 * @return the baseDao
	 */
	public BaseDao<Schedule> getBaseDao() {
		return baseDao;
	}

	/**
	 * @param baseDao the baseDao to set
	 */
	public void setBaseDao(BaseDao<Schedule> baseDao) {
		this.baseDao = baseDao;
	}

}
