package com.appointment.dao;

import java.util.List;

import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.appointment.domain.Resource;

@Repository("resourceDao")
public class ResourceDaoImpl extends AbstractBaseDao<Resource> implements
		ResourceDao {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public Resource update(Resource entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Resource> getAllResourcesByType(String type) {
		Query query = new Query();
		query.addCriteria(Criteria.where("resourceType").is(type));

		return mongoTemplate.find(query, Resource.class);

	}

	@Override
	public List<Resource> getAllResourcesByTypeNDept(String type,
			String department) {
		Query query = new Query();
		query.addCriteria(Criteria.where("resourceType").is(type)
				.and("department").is(department));
		return mongoTemplate.find(query, Resource.class);
	}

}
