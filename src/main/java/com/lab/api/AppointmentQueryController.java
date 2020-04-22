package com.lab.api;

import static java.util.Objects.requireNonNull;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lab.query.dto.AppointmentQueryDTO;
import com.lab.service.query.AppointmentQueryService;

import io.swagger.annotations.Api;

@RestController
@RequestMapping(value = "/appointment")
@Api(value = "Appointment Queries", tags = "List of events for an appointment")
public class AppointmentQueryController {

	private final AppointmentQueryService appointmentQueryService;
	
	public AppointmentQueryController(AppointmentQueryService appointmentQueryService) {
		this.appointmentQueryService = requireNonNull(appointmentQueryService);
	}
	
    @GetMapping("/{appointmentId}/events")
    public List<Object> listEventsForAccount(@PathVariable(value = "appointmentId") String appointmentId){
        return appointmentQueryService.listOfEventsForAppointment(appointmentId);
    }
    
    @GetMapping("/{appId}")
    public AppointmentQueryDTO findAppointmentById(@PathVariable(value = "appId") String appId){
        return appointmentQueryService.findById(appId);
    }
}
