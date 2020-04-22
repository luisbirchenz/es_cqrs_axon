package com.lab.event;

import com.lab.aggregates.AppStatus;

public class AppointmentStartedEvent extends BaseEvent<String> {

	public AppointmentStartedEvent(String id) {
		super(id, AppStatus.STARTED);
	}

}
