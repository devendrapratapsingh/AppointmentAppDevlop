package com.appointment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.appointment.domain.Schedule;
import com.appointment.services.BaseService;

@RestController
public class ScheduleController {

	/*
	 * @RequestMapping(value = "/{name}", method = RequestMethod.GET) public
	 * String getMovie(@PathVariable String name, ModelMap model) {
	 * 
	 * model.addAttribute("movie", name); return "list";
	 * 
	 * }
	 */
	@Autowired
	private BaseService<Schedule> service;

	@RequestMapping(value = URIConstants.GET_ALL_SCHEDULE, method = RequestMethod.GET)
	public List<Schedule> getAllSchedules() {

		List<Schedule> schedules = service.getAll(Schedule.class);

		return schedules;
	}

}
