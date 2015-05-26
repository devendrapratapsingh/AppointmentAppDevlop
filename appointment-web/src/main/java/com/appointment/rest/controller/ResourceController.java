package com.appointment.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.appointment.domain.Resource;
import com.appointment.services.CounterService;
import com.appointment.services.ResourceService;

@RestController
public class ResourceController {
	private static final String SEQENCE_NAME = "RESOURCE_SEQ";

	@Autowired
	private ResourceService service;

	@Autowired
	private CounterService counterService;

	@RequestMapping(value = URIConstants.ADD_RESOURCE, method = RequestMethod.POST, headers = "Accept=application/json")
	public Long addResourseType(@RequestBody Resource entity) {

		if (entity != null) {
			entity.setId(counterService.getNextSequence(SEQENCE_NAME));

			service.add(entity);

		}
		return entity.getId();

	}

	@RequestMapping(value = URIConstants.GET_RESOURCE_BY_TYPE, method = RequestMethod.GET)
	public List<Resource> getAllResourcesByType(
			@PathVariable("type") String type) {

		return service.getAllResourcesByType(type);
	}

	@RequestMapping(value = URIConstants.GET_RESOURCE_BY_TYPE_AND_DEPARTMENT, method = RequestMethod.GET)
	public List<Resource> getAllResourcesByTypeNDept(
			@PathVariable("type") String type,
			@PathVariable("department") String department) {

		return service.getAllResourcesByTypeNDept(type, department);
	}
}
