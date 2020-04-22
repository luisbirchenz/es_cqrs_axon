package com.lab.event;

import com.lab.aggregates.AppStatus;

public class AppointmentInProgressEvent extends BaseEvent<String> {

	public AppointmentInProgressEvent(String id) {
		super(id, AppStatus.IN_PROGRESS);
	}

}
