package org.ndhb.pycare.registration.aggregate;

import java.util.UUID;

import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;
import org.ndhb.pycare.registration.command.CreateAccountCommand;
import org.ndhb.pycare.registration.command.UpdateAccountCommand;
import org.ndhb.pycare.registration.command.UpdatePatientLocalIdCommand;
import org.ndhb.pycare.registration.command.UpdateRegistrationTypeCommand;
import org.ndhb.pycare.registration.command.UpdateStatusCommand;
import org.ndhb.pycare.registration.event.AccountCreatedEvent;
import org.ndhb.pycare.registration.event.AccountUpdatedEvent;
import org.ndhb.pycare.registration.event.PatientLocalIdUpdatedEvent;
import org.ndhb.pycare.registration.event.RegistrationTypeChangedEvent;
import org.ndhb.pycare.registration.event.StatusUpdatedEvent;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Aggregate
public class AccountAggregate {

    @AggregateIdentifier
    private UUID id;
    private String email;
    private String name;
    private String uhid;
    private String dob;
    private StatusType status;
    private RegistrationType registrationType;
    private int age;

    private String patientLocalId;


    @CommandHandler
    public AccountAggregate(CreateAccountCommand command) {

        AggregateLifecycle.apply(
                new AccountCreatedEvent(
                        command.getAccountId(),
                		command.getPatientLocalId(),
                        command.getUhid(),
                        command.getName(),
                        command.getEmail(),
                        command.getDob(),
                        command.getAge(),
                        command.getStatus(),
                        command.getRegistrationType()



                        
                )
        );
    }

    @EventSourcingHandler
    public void on(AccountCreatedEvent event) {
        this.id = event.getId();
        this.patientLocalId= event.getPatientLocalId();
        this.name = event.getName();
        this.email = event.getEmail();
        this.dob = event.getDob();
        this.uhid = event.getUhid();
        this.age = event.getAge();
        this.status =event.getStatus();
        this.registrationType= event.getRegistrationType();
    }

    

    @CommandHandler
    public void handle(UpdateAccountCommand command) {

        AggregateLifecycle.apply(
                new AccountUpdatedEvent(
                        command.getAccountId(),
                        command.getUhid(),
                        command.getName(),
                        command.getEmail(),
                        command.getDob(),
                        command.getAge(),
                        command.getStatus(),
                        command.getRegistrationType()



                        
                )
        );
    }

    @EventSourcingHandler
    public void on(AccountUpdatedEvent event) {
        this.id = event.getId();
        this.name = event.getName();
        this.email = event.getEmail();
        this.dob = event.getDob();
        this.uhid = event.getUhid();
        this.age = event.getAge();
        this.status =event.getStatus();
        this.registrationType= event.getRegistrationType();

    }

    
    @CommandHandler
    public void handle(UpdateStatusCommand command) {
        AggregateLifecycle.apply(
                new StatusUpdatedEvent(
                        command.getAccountId(),
                        command.getStatus()
                )
        );
    }

    @EventSourcingHandler
    public void on(RegistrationTypeChangedEvent event) {
        this.registrationType = event.getRegistrationType();
        		}
    
    
    @CommandHandler
    public void handle(UpdateRegistrationTypeCommand command) {
        AggregateLifecycle.apply(
                new RegistrationTypeChangedEvent(
                        command.getAccountId(),
                        command.getRegistrationType()
                )
        );
    }

    @EventSourcingHandler
    public void on(StatusUpdatedEvent event) {
        this.status =event.getStatus();
    }

    
    @EventSourcingHandler
    public void on(PatientLocalIdUpdatedEvent event) {
        this.patientLocalId = event.getPatientLocalId();
        		}
    
    
    @CommandHandler
    public void handle(UpdatePatientLocalIdCommand command) {
        AggregateLifecycle.apply(
                new PatientLocalIdUpdatedEvent(
                        command.getAccountId(),
                        command.getPatientLocalId()
                )
        );
    }

    
}
