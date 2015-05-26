package com.appointment.services;

import java.util.List;

import com.appointment.domain.Resource;

public interface ResourceService extends BaseService<Resource> {
	List<Resource> getAllResourcesByType(String type);

	List<Resource> getAllResourcesByTypeNDept(String type, String department);
}
