package com.lab.event;

import com.lab.aggregates.AppStatus;

public class AppointmentBookedEvent extends BaseEvent<String> {
	
	public AppointmentBookedEvent(String id) {
		super(id, AppStatus.BOOKED);
	}

}
