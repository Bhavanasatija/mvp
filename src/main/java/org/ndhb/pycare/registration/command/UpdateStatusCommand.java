package org.ndhb.pycare.registration.command;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.axonframework.modelling.command.TargetAggregateIdentifier;
import org.ndhb.pycare.registration.aggregate.StatusType;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateStatusCommand {

    @TargetAggregateIdentifier
    private UUID accountId;
    private StatusType status;
}
