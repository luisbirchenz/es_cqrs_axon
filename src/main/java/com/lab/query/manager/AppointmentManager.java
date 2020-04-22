package com.lab.query.manager;


import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.eventsourcing.EventSourcingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.lab.aggregates.AppointmentAggregate;
import com.lab.event.BaseEvent;
import com.lab.query.AppointmentEntity;
import com.lab.query.repository.AppointmentRepository;

@Component
public class AppointmentManager {
    @Autowired
    private AppointmentRepository appointmentRepository;

    @Autowired
    @Qualifier("appAggregateEventSourcingRepository")
    private EventSourcingRepository<AppointmentAggregate> appAggregateEventSourcingRepository;

    @EventSourcingHandler
    void on(BaseEvent<String> event){
        persistAccount(buildQueryApp(getAppointmentFromEvent(event)));
    }


    private AppointmentAggregate getAppointmentFromEvent(BaseEvent<String> event){
        return appAggregateEventSourcingRepository.load(event.id.toString()).getWrappedAggregate().getAggregateRoot();
    }

    private AppointmentEntity findExistingOrCreateQueryAppointment(String id){
        return appointmentRepository.findById(id).isPresent() ? appointmentRepository.findById(id).get() : new AppointmentEntity();
    }

    private AppointmentEntity buildQueryApp(AppointmentAggregate appointmentAggregate){
    	AppointmentEntity accountQueryEntity = findExistingOrCreateQueryAppointment(appointmentAggregate.getId());

        accountQueryEntity.setId(appointmentAggregate.getId());
        accountQueryEntity.setStartDate(appointmentAggregate.getStartDate());
        accountQueryEntity.setEndDate(appointmentAggregate.getEndDate());
        accountQueryEntity.setStatus(appointmentAggregate.getStatus().name());
        accountQueryEntity.setProvider(appointmentAggregate.getProvider());
        accountQueryEntity.setUser(appointmentAggregate.getUser());

        return accountQueryEntity;
    }

    private void persistAccount(AppointmentEntity appointmentEntity){
    	appointmentRepository.save(appointmentEntity);
    }
}
