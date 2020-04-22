package com.lab.query.dto;

import java.time.LocalDateTime;

import com.lab.dto.AppointmentDTO;

public class AppointmentQueryDTO extends AppointmentDTO{
	
	private String id;

	public AppointmentQueryDTO(String id, LocalDateTime startDate, LocalDateTime endDate, String provider, String user) {
		super();
		this.id = id;
		setStartDate(startDate);
		setEndDate(endDate);
		setProvider(provider);
		setUser(user);
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	

}
