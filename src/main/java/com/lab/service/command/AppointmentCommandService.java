package com.lab.service.command;

import java.util.concurrent.CompletableFuture;

import com.lab.dto.AppointmentDTO;

public interface AppointmentCommandService {

	CompletableFuture<String> createAppointment(AppointmentDTO appointmentDTO);
	CompletableFuture<String> startAppointment(String appointmentId);	
	CompletableFuture<String> bookAppointment(String appointmentId);
	CompletableFuture<String> cancelAppointment(String appointmentId);
	CompletableFuture<String> completeAppointment(String appointmentId);
}