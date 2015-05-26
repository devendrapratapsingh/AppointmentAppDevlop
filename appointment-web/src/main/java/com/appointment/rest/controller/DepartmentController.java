package com.appointment.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.appointment.domain.Department;
import com.appointment.services.CounterService;
import com.appointment.services.DepartmentService;

@RestController
public class DepartmentController {
	private static final String SEQENCE_NAME = "DEPARTMENT_SEQ";

	@Autowired
	private DepartmentService service;

	@Autowired
	private CounterService counterService;

	@RequestMapping(value = URIConstants.ADD_DEPARTMENT, method = RequestMethod.POST, headers = "Accept=application/json")
	public Long addDepartment(@RequestBody Department entity) {

		if (entity != null) {
			entity.setId(counterService.getNextSequence(SEQENCE_NAME));

			service.add(entity);

		}
		return entity.getId();

	}

	@RequestMapping(value = URIConstants.GET_ALL_DEPARTMENT, method = RequestMethod.GET)
	public List<Department> getAllDepartments() {
		return service.getAll(Department.class);
	}
}
