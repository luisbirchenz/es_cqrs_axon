package com.lab.event;

import java.time.LocalDateTime;

import com.lab.aggregates.AppStatus;

public class AppointmentCreatedEvent extends BaseEvent<String>{

	public final LocalDateTime startDate;
	public final LocalDateTime endDate;
	public final String provider;
	public final String user;
	
	public AppointmentCreatedEvent(String id, LocalDateTime startDate, LocalDateTime endDate,
			String provider, String user) {
		super(id, AppStatus.NEW);
		this.startDate = startDate;
		this.endDate = endDate;
		this.provider = provider;
		this.user = user;
	}

}
