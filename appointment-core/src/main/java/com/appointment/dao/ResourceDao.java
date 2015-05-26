package com.appointment.dao;

import java.util.List;

import com.appointment.domain.Resource;

public interface ResourceDao extends BaseDao<Resource> {
	List<Resource> getAllResourcesByType(String type);

	List<Resource> getAllResourcesByTypeNDept(String type, String department);
}
