package com.lab.service.query;

import java.util.List;

import com.lab.query.dto.AppointmentQueryDTO;

public interface AppointmentQueryService {
	public List<Object> listOfEventsForAppointment(String appointmentId);
	public AppointmentQueryDTO findById(String appointmentId);
}