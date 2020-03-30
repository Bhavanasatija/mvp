package org.ndhb.pycare.registration.command;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.axonframework.modelling.command.TargetAggregateIdentifier;
import org.ndhb.pycare.registration.aggregate.RegistrationType;
import org.ndhb.pycare.registration.aggregate.StatusType;

import java.util.Date;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateAccountCommand {

	@TargetAggregateIdentifier
    private UUID accountId;
	private String uhid;
	private String patientName;
	//private int patientAge;
	private StatusType status;
	private RegistrationType registrationType;
	private String email;
	private Date dob;
	private int birthOrder;
	private int parity;
	private int gravida;
	private int identityUnknownIndicator;
	private int causeOfDeathKnownIndicator;
	private String patientAddressType;
	private String patientAddress;
	private String patientLandlineNumber;
	private String patientMobileNumber;
	private int patientClass;
	private int pregnancyIndicator;
	private int durationOfPregnancy;
	private String insuredCardID;
	private String insuredPolicyID;
	private String secondaryHealthInsurancePolicyID;
	private int secondaryHealthInsurancePolicyIndicator;
}
