package org.ndhb.pycare.registration.event;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;
import java.util.UUID;

import org.ndhb.pycare.registration.aggregate.RegistrationType;
import org.ndhb.pycare.registration.aggregate.StatusType;

@Data
@AllArgsConstructor
public class AccountCreatedEvent {
	private UUID id;
    private String patientLocalId;
    private String uhid;
    private String name;
    private String email ;
    private String dob ;
    private int age ;
    private StatusType status;
    private RegistrationType registrationType;

   
	
	
}
