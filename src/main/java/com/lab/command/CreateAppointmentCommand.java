package com.lab.command;

import java.time.LocalDateTime;

public class CreateAppointmentCommand extends BaseCommand<String>{
	
	public final LocalDateTime startDate;
	public final LocalDateTime endDate;
	public final String provider;
	public final String user;

	public CreateAppointmentCommand(String id, LocalDateTime startDate, LocalDateTime endDate, 
			String provider, String user) {
		super(id);
		this.startDate = startDate;
		this.endDate = endDate;
		this.provider = provider;
		this.user = user;
	}
	
}
