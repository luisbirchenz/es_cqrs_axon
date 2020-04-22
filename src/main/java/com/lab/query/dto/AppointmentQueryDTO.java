package com.lab.query.dto;

import java.time.LocalDateTime;

import com.lab.dto.AppointmentDTO;

public class AppointmentQueryDTO extends AppointmentDTO{
	
	private String id;
	private String status;

	public AppointmentQueryDTO(String id, LocalDateTime startDate, LocalDateTime endDate, String status, String provider, String user) {
		super();
		this.id = id;
		this.status = status;
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
