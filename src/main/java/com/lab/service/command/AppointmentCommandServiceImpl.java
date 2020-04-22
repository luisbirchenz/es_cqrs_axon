package com.lab.service.command;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;

import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.stereotype.Service;

import com.lab.command.BookAppointmentCommand;
import com.lab.command.CreateAppointmentCommand;
import com.lab.command.FinishAppointmentCommand;
import com.lab.command.StartAppointmentCommand;
import com.lab.command.CancelAppointmentCommand;
import com.lab.dto.AppointmentDTO;

@Service
public class AppointmentCommandServiceImpl implements AppointmentCommandService {
	
	private final CommandGateway commandGateway;
	
	public AppointmentCommandServiceImpl(CommandGateway commandGateway) {
		this.commandGateway = commandGateway;
	}
	
	@Override
	public CompletableFuture<String> createAppointment(AppointmentDTO appointmentDTO) {
		return commandGateway.send(
				new CreateAppointmentCommand(
						UUID.randomUUID().toString(), 
						appointmentDTO.getStartDate(), 
						appointmentDTO.getEndDate(), 
						appointmentDTO.getProvider(),
						appointmentDTO.getUser())
				);
	}

	@Override
	public CompletableFuture<String> startAppointment(String appointmentId) {
		return commandGateway.send(new StartAppointmentCommand(appointmentId));
	}
	
	@Override
	public CompletableFuture<String> bookAppointment(String appointmentId) {
		return commandGateway.send(new BookAppointmentCommand(appointmentId));
	}

	@Override
	public CompletableFuture<String> cancelAppointment(String appointmentId) {
		return commandGateway.send(new CancelAppointmentCommand(appointmentId));
	}

	@Override
	public CompletableFuture<String> completeAppointment(String appointmentId) {
		return commandGateway.send(new FinishAppointmentCommand(appointmentId));
	}
}
