package com.appointment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.appointment.domain.Schedule;
import com.appointment.services.ScheduleServiceImpl;

@RestController
public class ScheduleController {

	@Autowired
	private ScheduleServiceImpl scheduleService;

	@RequestMapping("/schedule")
	public Schedule getSchedule() {
		return 

	}
}
