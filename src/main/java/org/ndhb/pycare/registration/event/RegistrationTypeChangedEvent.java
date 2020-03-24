package org.ndhb.pycare.registration.event;

import java.util.UUID;

import org.ndhb.pycare.registration.aggregate.RegistrationType;

import lombok.Value;
@Value
public class RegistrationTypeChangedEvent {
	 private final UUID id;
	    private final RegistrationType registrationType;
}
