package com.appointment.dao;

import java.io.Serializable;
import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

/**
 * @author x075093
 *
 */
/**
 * @author uniquenotion
 *
 * @param <T>
 */
@Repository
public abstract class AbstractBaseDao<T> implements BaseDao<T>, Serializable {

	private static final long serialVersionUID = 1L;
	@Autowired
	protected MongoTemplate mongoTemplate;

	public void setMongoTemplate(MongoTemplate template) {
		this.mongoTemplate = template;
	}

	public MongoTemplate getMongoTemplate() {
		return this.mongoTemplate;
	}

	public T selectByPk(ObjectId id, Class<T> entityClass) {
		return (T) mongoTemplate.findById(id, entityClass);
	}

	public T insert(T entity) {
		mongoTemplate.save(entity);
		return entity;
	}

	@Override
	public void delete(T entity, Class<T> entityClass) {
		mongoTemplate.remove(entity);
	}

	@Override
	public List<T> findAll(Class<T> entityClass) {

		return (List<T>) mongoTemplate.findAll(entityClass);
	}

	@Override
	public Long countAll(Class<T> entityClass) {
		return mongoTemplate.count(new Query(), entityClass);
	}

}
