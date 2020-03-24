package org.ndhb.pycare.registration.rest.dto;

import lombok.Value;

import org.ndhb.pycare.registration.aggregate.RegistrationType;
import org.ndhb.pycare.registration.aggregate.StatusType;

@Value
public class AccountUpdateDTO {
    private String uhid;
    private String name;
    private String email;
    private String dob;
    private int age;
    private StatusType status;
    private RegistrationType registrationType;



}
