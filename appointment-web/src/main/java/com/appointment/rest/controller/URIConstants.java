package com.appointment.rest.controller;

public class URIConstants {
	public static final String DUMMY_EMP = "/rest/emp/dummy";
	public static final String GET_EMP = "/rest/emp/{id}";
	public static final String GET_ALL_SCHEDULE = "/rest/schedules";
	public static final String GET_SLOTS = "/rest/schedules/{orgname}";
	public static final String ADD_SCHEDULE = "/rest/schedules/add";
	public static final String ADD_RESERVATION = "/rest/reservation/add";
	public static final String ADD_RESOURCE_TYPE = "/rest/resourcetype/add";
	public static final String GET_ALL_RESOURCE_TYPE = "/rest/resourcetype";
	public static final String ADD_RESOURCE = "/rest/resource/add";
	public static final String GET_RESOURCE_BY_TYPE = "/rest/resource/{type}";
	public static final String GET_RESOURCE_BY_TYPE_AND_DEPARTMENT = "/rest/resource/{type}/{department}";
	public static final String ADD_DEPARTMENT = "/rest/department/add";
	public static final String GET_ALL_DEPARTMENT = "/rest/department";
	public static final String CREATE_EMP = "/rest/emp/create";
	public static final String DELETE_EMP = "/rest/emp/delete/{id}";
}
