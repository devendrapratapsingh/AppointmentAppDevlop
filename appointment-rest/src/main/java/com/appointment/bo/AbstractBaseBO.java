package com.appointment.bo;


import java.io.Serializable;
import java.util.List;

import org.apache.log4j.Logger;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.appointment.dao.BaseDao;

/**
 * @author Amit Thapar
 *
 */
@Component
public abstract class AbstractBaseBO<T> implements BaseBO<T>, Serializable {
	
	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(AbstractBaseBO.class);
	@Autowired
	private BaseDao<T> baseDao;
	
	@Override
	public T add(T entity) {
		logger.debug("Adding instance");
		return baseDao.insert(entity);
	}

	@Override
	public void remove(T entity, Class<T> entityClass) {
		logger.debug("Removing instance");
		baseDao.delete(entity, entityClass);
	}

	@Override
	public T get(ObjectId id,  Class<T> entityClass) {
		logger.debug("Get instance");
		return baseDao.selectByPk(id, entityClass);
	}

	@Override
	public List<T> getAll(Class<T> entityClass) {
		logger.debug("Getting All instances");
		return (List<T>) baseDao.findAll(entityClass);
	}

	@Override
	public Long countAll(Class<T> entityClass) {
		logger.debug("Count All instances");
		return baseDao.countAll(entityClass);
	}
	
}
