package org.ndhb.pycare.registration.event;

import lombok.Value;

import java.util.UUID;

import org.ndhb.pycare.registration.aggregate.StatusType;

@Value
public class PatientLocalIdUpdatedEvent {

    private UUID id;
    private String patientLocalId;
}
