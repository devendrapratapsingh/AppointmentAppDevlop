package com.appointment.dao;

import org.springframework.stereotype.Repository;

import com.appointment.domain.ResourceType;

@Repository("resourceTypeDao")
public class ResourceTypeDaoImpl extends AbstractBaseDao<ResourceType>
		implements ResourceTypeDao {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public ResourceType update(ResourceType entity) {
		// TODO Auto-generated method stub
		return null;
	}

}
