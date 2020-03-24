package org.ndhb.pycare.registration.rest.dto;

import lombok.Data;
import lombok.NoArgsConstructor;


import org.ndhb.pycare.registration.aggregate.StatusType;

@Data
@NoArgsConstructor
public class StatusDTO {
    private StatusType status;

}
