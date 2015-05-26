package com.appointment.bo;

import java.util.List;

import com.appointment.domain.Resource;

public interface ResourceBO extends BaseBO<Resource> {
	List<Resource> getAllResourcesByType(String type);

	List<Resource> getAllResourcesByTypeNDept(String type, String department);
}
