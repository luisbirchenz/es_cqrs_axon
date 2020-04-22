package com.lab.event;

import com.lab.aggregates.AppStatus;

public class AppointmentFinishedEvent extends BaseEvent<String> {

	public AppointmentFinishedEvent(String id) {
		super(id, AppStatus.FINISHED);
	}
	

}
