package com.lab.event;

import com.lab.aggregates.AppStatus;

public class AppointmentCancelledEvent extends BaseEvent<String> {

	public AppointmentCancelledEvent(String id) {
		super(id, AppStatus.CANCELLED);
	}

}

