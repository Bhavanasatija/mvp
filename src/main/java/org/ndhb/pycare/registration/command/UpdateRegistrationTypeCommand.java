package org.ndhb.pycare.registration.command;

import java.util.UUID;

import org.axonframework.modelling.command.TargetAggregateIdentifier;
import org.ndhb.pycare.registration.aggregate.RegistrationType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateRegistrationTypeCommand {

	@TargetAggregateIdentifier
    private UUID accountId;
    private RegistrationType registrationType;
}
