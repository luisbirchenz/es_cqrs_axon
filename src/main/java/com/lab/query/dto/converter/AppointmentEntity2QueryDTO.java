package com.lab.query.dto.converter;

import java.util.function.Function;

import org.springframework.stereotype.Component;

import com.lab.query.AppointmentEntity;
import com.lab.query.dto.AppointmentQueryDTO;

@Component
public class AppointmentEntity2QueryDTO implements Function<AppointmentEntity, AppointmentQueryDTO>{

	@Override
	public AppointmentQueryDTO apply(AppointmentEntity entity) {
		return new AppointmentQueryDTO(entity.getId(), entity.getStartDate(), 
				entity.getEndDate(), entity.getProvider(), entity.getUser());
	}

}


