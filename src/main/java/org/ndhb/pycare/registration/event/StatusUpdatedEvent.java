package org.ndhb.pycare.registration.event;

import lombok.Value;

import java.util.UUID;

import org.ndhb.pycare.registration.aggregate.StatusType;

@Value
public class StatusUpdatedEvent {

    private UUID id;
    private StatusType status;
}
