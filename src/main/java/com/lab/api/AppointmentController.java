package com.lab.api;


import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.*;

import com.lab.dto.AppointmentDTO;
import com.lab.service.command.AppointmentCommandService;

import static java.util.Objects.requireNonNull;

import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping(value = "/appointment")
@Api(value = "Appointment Commands", tags = "Appointment Commands Endpoints")
public class AppointmentController {
	
	private final AppointmentCommandService appointmentCommandService;
	
	public AppointmentController(AppointmentCommandService appointmentCommandService) {
		this.appointmentCommandService = requireNonNull(appointmentCommandService);
	}
	
	@PostMapping
	public CompletableFuture<String> createAppointment(AppointmentDTO appointmentDTO) {
		return appointmentCommandService.createAppointment(appointmentDTO);
	}
	

	@PutMapping(value = "/start/{appointmentId}")
	public CompletableFuture<String> startAppointment(String appointmentId){
		return appointmentCommandService.startAppointment(appointmentId);
	}
	
	@PutMapping(value = "/book/{appointmentId}")
	public CompletableFuture<String> bookAppointment(String appointmentId){
		return appointmentCommandService.bookAppointment(appointmentId);
	}

	@PutMapping(value = "/cancel/{appointmentId}")
	public CompletableFuture<String> cancelAppointment(String appointmentId){
		return appointmentCommandService.cancelAppointment(appointmentId);
	}
	
	@PutMapping(value = "/complete/{appointmentId}")
	public CompletableFuture<String> completeAppointment(String appointmentId){
		return appointmentCommandService.completeAppointment(appointmentId);
	}

}
