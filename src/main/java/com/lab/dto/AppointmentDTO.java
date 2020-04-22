package com.lab.dto;

import java.time.LocalDateTime;

import org.springframework.format.annotation.DateTimeFormat;

import io.swagger.annotations.ApiModelProperty;

public class AppointmentDTO {

	@ApiModelProperty(value = "The start date and time of the appointment", example = "2020-04-19T09:00:00", position = 0)
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) 
	private LocalDateTime startDate;
	@ApiModelProperty(value = "The end date and time of the appointment", example= "2020-04-19T10:00:00", position = 1)
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) 
	private LocalDateTime endDate;
	@ApiModelProperty(value = "With whom will the meeting be held", example = "HR interviewer",  position = 2)
	private String provider;
	@ApiModelProperty(value = "The one who asked for the meeting", example = "Luis", position = 3)
	private String user;
	
	public AppointmentDTO() {}

	public LocalDateTime getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDateTime startDate) {
		this.startDate = startDate;
	}

	public LocalDateTime getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDateTime endDate) {
		this.endDate = endDate;
	}

	public String getProvider() {
		return provider;
	}

	public void setProvider(String provider) {
		this.provider = provider;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}
}
