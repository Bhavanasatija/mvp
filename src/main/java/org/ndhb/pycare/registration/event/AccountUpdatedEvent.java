package org.ndhb.pycare.registration.event;

import java.util.UUID;

import org.ndhb.pycare.registration.aggregate.RegistrationType;
import org.ndhb.pycare.registration.aggregate.StatusType;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AccountUpdatedEvent {
	private UUID id;
    private String uhid;
    private String name;
    private String email ;
    private String dob ;
    private int age ;
    private StatusType status;
    private RegistrationType registrationType;

   
	
	
}
