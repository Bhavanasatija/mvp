package org.ndhb.pycare.registration.rest.dto;

import lombok.Value;

import java.util.Date;

import org.ndhb.pycare.registration.aggregate.RegistrationType;
import org.ndhb.pycare.registration.aggregate.StatusType;

@Value
public class AccountCreationDTO {
	private String uhid;
	private String patientName;
	private Date dob;
	//private int patientAge;
	private StatusType status;
	private RegistrationType registrationType;
	private String email;
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
	private int secondaryHealthInsurancePolicyIndicator;
	private String secondaryHealthInsurancePolicyID;



}
