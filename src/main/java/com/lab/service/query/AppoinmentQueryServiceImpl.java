package com.lab.service.query;

import org.axonframework.eventsourcing.eventstore.EventStore;
import org.springframework.stereotype.Service;

import com.lab.query.dto.AppointmentQueryDTO;
import com.lab.query.dto.converter.AppointmentEntity2QueryDTO;
import com.lab.query.repository.AppointmentRepository;

import java.util.List;
import java.util.stream.Collectors;
import static java.util.Objects.requireNonNull;

@Service
public class AppoinmentQueryServiceImpl implements AppointmentQueryService {
	
    private final EventStore eventStore;
    private final AppointmentRepository appointmentRepository;
    private final AppointmentEntity2QueryDTO converter;

    public AppoinmentQueryServiceImpl(
    		EventStore eventStore, 
    		AppointmentRepository appointmentRepository,
    		AppointmentEntity2QueryDTO converter) {        
		this.eventStore = requireNonNull(eventStore);
		this.appointmentRepository = requireNonNull(appointmentRepository);
		this.converter = requireNonNull(converter);
    }

    public List<Object> listOfEventsForAppointment(String appointmentId) {
        return eventStore.readEvents(appointmentId)
        		.asStream().map( 
        				s -> s.getPayload())
        		.collect(Collectors.toList());
    }

	@Override
	public AppointmentQueryDTO findById(String appointmentId) {
		return converter.apply(
				appointmentRepository.findById(appointmentId).get()
		);
	}

}

