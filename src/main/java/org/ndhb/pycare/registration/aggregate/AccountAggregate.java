package org.ndhb.pycare.registration.aggregate;

import java.time.LocalDate;
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
	private String alternateUniqueIdentificationNumberType;
	private String alternateUniqueIdentificationNumber;
	private String patientLocalId;
	private String email;
	private String uhid;
	private LocalDate dob;
	private String patientName;
	// private int patientAge;
	private int birthOrder;
	private int parity;
	private int gravida;
	private int identityUnknownIndicator;
	private int causeOfDeathKnownIndicator;
	// private String patientAddress;
	private String houseNo;
	private String locality;
	private String subLocality1;
	private String subLocality2;
	private String state;
	private String pin;
	private String patientAddressType;
	private String patientLandlineNumber;
	private String patientMobileNumber;
	private int patientClass;
	private int pregnancyIndicator;
	private int durationOfPregnancy;
	private String insuredCardID;
	private String insuredPolicyID;
	private String secondaryHealthInsurancePolicyID;
	private int secondaryHealthInsurancePolicyIndicator;
	private String payorAssignedBeneficiaryID;
	private StatusType status;
	private RegistrationType registrationType;
	// private Address address;

	@CommandHandler
	public AccountAggregate(CreateAccountCommand command) {

		AggregateLifecycle.apply(new AccountCreatedEvent(command.getAccountId(),
				command.getAlternateUniqueIdentificationNumberType(), command.getAlternateUniqueIdentificationNumber(),
				command.getPatientLocalId(), command.getUhid(), command.getPatientName(), command.getDob(),
				// command.getPatientAge(),
				command.getStatus(), command.getRegistrationType(), command.getEmail(), command.getBirthOrder(),
				command.getParity(), command.getGravida(), command.getIdentityUnknownIndicator(),
				command.getCauseOfDeathKnownIndicator(), command.getPatientAddressType(),
				// command.getPatientAddress(),
				command.getHouseNo(), command.getLocality(), command.getSubLocality1(), command.getSubLocality2(),
				command.getState(), command.getPin(), command.getPatientLandlineNumber(),
				command.getPatientMobileNumber(), command.getPatientClass(), command.getPregnancyIndicator(),
				command.getDurationOfPregnancy(), command.getInsuredCardID(), command.getInsuredPolicyID(),
				command.getSecondaryHealthInsurancePolicyIndicator(), command.getSecondaryHealthInsurancePolicyID()

		));
	}

	@EventSourcingHandler
	public void on(AccountCreatedEvent event) {
		this.id = event.getAccountId();
		this.patientLocalId = event.getPatientLocalId();
		this.patientName = event.getPatientName();
		this.email = event.getEmail();
		this.dob = event.getDob();
		this.uhid = event.getUhid();
		this.status = event.getStatus();
		this.registrationType = event.getRegistrationType();
		this.birthOrder = event.getBirthOrder();
		this.identityUnknownIndicator = event.getIdentityUnknownIndicator();
		this.causeOfDeathKnownIndicator = event.getCauseOfDeathKnownIndicator();
		this.durationOfPregnancy = event.getDurationOfPregnancy();
		this.pregnancyIndicator = event.getPregnancyIndicator();
		this.gravida = event.getGravida();
		this.parity = event.getParity();
		// this.patientAddress = event.getPatientAddress();
		this.houseNo = event.getHouseNo();
		this.locality = event.getLocality();
		this.subLocality1 = event.getSubLocality1();
		this.subLocality2 = event.getSubLocality2();
		this.state = event.getState();
		this.pin = event.getPin();
		this.patientAddressType = event.getPatientAddressType();
		this.insuredCardID = event.getPatientMobileNumber();
		this.patientMobileNumber = event.getPatientMobileNumber();
		this.patientLandlineNumber = event.getPatientLandlineNumber();
		this.patientClass = event.getPatientClass();
		this.secondaryHealthInsurancePolicyID = event.getSecondaryHealthInsurancePolicyID();
		this.secondaryHealthInsurancePolicyIndicator = event.getSecondaryHealthInsurancePolicyIndicator();
		this.insuredCardID = event.getInsuredCardID();
		this.insuredPolicyID = event.getInsuredPolicyID();
		this.alternateUniqueIdentificationNumber = event.getAlternateUniqueIdentificationNumber();
		this.alternateUniqueIdentificationNumberType = event.getAlternateUniqueIdentificationNumberType();
	}

	@CommandHandler
	public void handle(UpdateAccountCommand command) {

		AggregateLifecycle.apply(new AccountUpdatedEvent(command.getAccountId(),
				command.getAlternateUniqueIdentificationNumberType(), command.getAlternateUniqueIdentificationNumber(),
				command.getUhid(), command.getPatientName(), command.getDob(),
				// command.getPatientAge(),
				command.getStatus(), command.getRegistrationType(), command.getEmail(), command.getBirthOrder(),
				command.getParity(), command.getGravida(), command.getIdentityUnknownIndicator(),
				command.getCauseOfDeathKnownIndicator(), command.getPatientAddressType(),
				// command.getPatientAddress(),
				command.getHouseNo(), command.getLocality(), command.getSubLocality1(), command.getSubLocality2(),
				command.getState(), command.getPin(), command.getPatientLandlineNumber(),
				command.getPatientMobileNumber(), command.getPatientClass(), command.getPregnancyIndicator(),
				command.getDurationOfPregnancy(), command.getInsuredCardID(), command.getInsuredPolicyID(),
				command.getSecondaryHealthInsurancePolicyIndicator(), command.getSecondaryHealthInsurancePolicyID()

		));
	}

	@EventSourcingHandler
	public void on(AccountUpdatedEvent event) {
		this.id = event.getAccountId();
		this.patientName = event.getPatientName();
		this.email = event.getEmail();
		this.dob = event.getDob();
		this.uhid = event.getUhid();
		this.status = event.getStatus();
		this.registrationType = event.getRegistrationType();
		this.birthOrder = event.getBirthOrder();
		this.identityUnknownIndicator = event.getIdentityUnknownIndicator();
		this.causeOfDeathKnownIndicator = event.getCauseOfDeathKnownIndicator();
		this.durationOfPregnancy = event.getDurationOfPregnancy();
		this.pregnancyIndicator = event.getPregnancyIndicator();
		this.gravida = event.getGravida();
		this.parity = event.getParity();
		// this.patientAddress = event.getPatientAddress();
		this.houseNo = event.getHouseNo();
		this.locality = event.getLocality();
		this.subLocality1 = event.getSubLocality1();
		this.subLocality2 = event.getSubLocality2();
		this.state = event.getState();
		this.pin = event.getPin();
		this.patientAddressType = event.getPatientAddressType();
		this.insuredCardID = event.getPatientMobileNumber();
		this.patientMobileNumber = event.getPatientMobileNumber();
		this.patientLandlineNumber = event.getPatientLandlineNumber();
		this.patientClass = event.getPatientClass();
		this.secondaryHealthInsurancePolicyID = event.getSecondaryHealthInsurancePolicyID();
		this.secondaryHealthInsurancePolicyIndicator = event.getSecondaryHealthInsurancePolicyIndicator();
		this.insuredCardID = event.getInsuredCardID();
		this.insuredPolicyID = event.getInsuredPolicyID();
		this.alternateUniqueIdentificationNumber = event.getAlternateUniqueIdentificationNumber();
		this.alternateUniqueIdentificationNumberType = event.getAlternateUniqueIdentificationNumberType();
	}

	@CommandHandler
	public void handle(UpdateStatusCommand command) {
		AggregateLifecycle.apply(new StatusUpdatedEvent(command.getAccountId(), command.getStatus()));
	}

	@EventSourcingHandler
	public void on(RegistrationTypeChangedEvent event) {
		this.registrationType = event.getRegistrationType();
	}

	@CommandHandler
	public void handle(UpdateRegistrationTypeCommand command) {
		AggregateLifecycle
				.apply(new RegistrationTypeChangedEvent(command.getAccountId(), command.getRegistrationType()));
	}

	@EventSourcingHandler
	public void on(StatusUpdatedEvent event) {
		this.status = event.getStatus();
	}

	@EventSourcingHandler
	public void on(PatientLocalIdUpdatedEvent event) {
		this.patientLocalId = event.getPatientLocalId();
	}

	@CommandHandler
	public void handle(UpdatePatientLocalIdCommand command) {
		AggregateLifecycle.apply(new PatientLocalIdUpdatedEvent(command.getAccountId(), command.getPatientLocalId()));
	}

}
