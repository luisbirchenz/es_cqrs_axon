package com.lab.settings;

import com.lab.aggregates.AppointmentAggregate;
import org.axonframework.eventsourcing.EventSourcingRepository;
import org.axonframework.eventsourcing.eventstore.EventStore;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AxonSetting {
    @Bean
    EventSourcingRepository<AppointmentAggregate> appAggregateEventSourcingRepository(EventStore eventStore){
        EventSourcingRepository<AppointmentAggregate> repository = EventSourcingRepository
        		.builder(AppointmentAggregate.class).eventStore(eventStore).build();
        return repository;
    }
}
