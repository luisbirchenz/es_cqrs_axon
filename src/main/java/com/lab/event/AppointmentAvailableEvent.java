package com.lab.event;

import com.lab.aggregates.AppStatus;

public class AppointmentAvailableEvent extends BaseEvent<String> {

	public AppointmentAvailableEvent(String id) {
		super(id, AppStatus.AVAILABLE);
	}

}
