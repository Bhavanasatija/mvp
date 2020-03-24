package org.ndhb.pycare.registration.command;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.axonframework.modelling.command.TargetAggregateIdentifier;
import org.ndhb.pycare.registration.aggregate.RegistrationType;
import org.ndhb.pycare.registration.aggregate.StatusType;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateAccountCommand {

	@TargetAggregateIdentifier
    private UUID accountId;
    private String patientLocalId;
    private String uhid;
    private String name;
    private String email ;
    private String dob ;
    private int age ;
    private StatusType status;
    private RegistrationType registrationType;


    
}
