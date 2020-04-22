package com.lab.aggregates;

import java.time.LocalDateTime;

import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;
import org.axonframework.eventsourcing.EventSourcingHandler;

import com.lab.command.BookAppointmentCommand;
import com.lab.command.CancelAppointmentCommand;
import com.lab.command.CreateAppointmentCommand;
import com.lab.command.FinishAppointmentCommand;
import com.lab.command.StartAppointmentCommand;
import com.lab.event.AppointmentAvailableEvent;
import com.lab.event.AppointmentBookedEvent;
import com.lab.event.AppointmentCancelledEvent;
import com.lab.event.AppointmentCreatedEvent;
import com.lab.event.AppointmentFinishedEvent;
import com.lab.event.AppointmentInProgressEvent;
import com.lab.event.AppointmentStartedEvent;

@Aggregate
@SuppressWarnings("unused")
public class AppointmentAggregate {
	
	@AggregateIdentifier
	private String id;
	private AppStatus status;
	private LocalDateTime startDate;
	private LocalDateTime endDate;
	private String provider;
	private String user;
	
	public AppointmentAggregate() {}
	
	@CommandHandler
	public AppointmentAggregate(CreateAppointmentCommand cmd) {
		AggregateLifecycle.apply(new AppointmentCreatedEvent(cmd.id, cmd.startDate, cmd.endDate, cmd.provider, cmd.user));
	}
	
	@EventSourcingHandler
	private void on(AppointmentCreatedEvent appointmentCreatedEvent) {
		this.id = appointmentCreatedEvent.id;
		this.startDate = appointmentCreatedEvent.startDate;
		this.endDate = appointmentCreatedEvent.endDate;
		this.provider = appointmentCreatedEvent.provider;
		this.user = appointmentCreatedEvent.user;
		
		AggregateLifecycle.apply(new AppointmentAvailableEvent(this.id));
	}
	
	@EventSourcingHandler
    protected void on(AppointmentAvailableEvent appointmentAvailableEvent){
        this.status = appointmentAvailableEvent.status;
    }
	
	
	@CommandHandler
	public void on(BookAppointmentCommand bookAppointmentCommand) {
		AggregateLifecycle.apply(new AppointmentBookedEvent(bookAppointmentCommand.id));
	}
	
	@EventSourcingHandler
	public void on(AppointmentBookedEvent appointmentBookedEvent) {
		this.status = appointmentBookedEvent.status;
	}
	
	@CommandHandler
	public void on(StartAppointmentCommand startAppointmentCommand) {
		AggregateLifecycle.apply(new AppointmentStartedEvent(startAppointmentCommand.id));
	}
	
	@EventSourcingHandler
	public void on(AppointmentStartedEvent appointmentStartedEvent) {
		this.status = appointmentStartedEvent.status;
		AggregateLifecycle.apply(new AppointmentInProgressEvent(appointmentStartedEvent.id));
	}
	
	@EventSourcingHandler
	public void on(AppointmentInProgressEvent appointmentInProgressEvent) {
		this.status = appointmentInProgressEvent.status;
	}
	
	@CommandHandler
	public void on(FinishAppointmentCommand finishAppointmentCommand) {
		AggregateLifecycle.apply(new AppointmentFinishedEvent(finishAppointmentCommand.id));
	}
	
	@EventSourcingHandler
	public void on(AppointmentFinishedEvent appointmentFinishedEvent) {
		this.status = appointmentFinishedEvent.status;
	}
	
	@CommandHandler
	public void on(CancelAppointmentCommand cancelAppointmentCommand) {
		AggregateLifecycle.apply(new AppointmentCancelledEvent(cancelAppointmentCommand.id));
	}
	
	@EventSourcingHandler
	public void on(AppointmentCancelledEvent appointmentCancelledEvent) {
		this.status = appointmentCancelledEvent.status;
		AggregateLifecycle.apply(new AppointmentFinishedEvent(appointmentCancelledEvent.id));
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public AppStatus getStatus() {
		return status;
	}

	public void setStatus(AppStatus status) {
		this.status = status;
	}

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
