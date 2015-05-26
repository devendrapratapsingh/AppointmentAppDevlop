package com.appointment.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.appointment.domain.ResourceType;
import com.appointment.services.CounterService;
import com.appointment.services.ResourceTypeService;

@RestController
public class ResourceTypeController {
	private static final String SEQENCE_NAME = "RESOURCE_TYPE_SEQ";

	@Autowired
	private ResourceTypeService service;

	@Autowired
	private CounterService counterService;

	@RequestMapping(value = URIConstants.ADD_RESOURCE_TYPE, method = RequestMethod.POST, headers = "Accept=application/json")
	public Long addResourseType(@RequestBody ResourceType entity) {

		if (entity != null) {
			entity.setId(counterService.getNextSequence(SEQENCE_NAME));

			service.add(entity);

		}
		return entity.getId();

	}

	@RequestMapping(value = URIConstants.GET_ALL_RESOURCE_TYPE, method = RequestMethod.GET)
	public List<ResourceType> getAllResourceTypes() {

		return service.getAll(ResourceType.class);
	}
}
