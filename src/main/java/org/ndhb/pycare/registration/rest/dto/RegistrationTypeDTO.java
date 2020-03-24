package org.ndhb.pycare.registration.rest.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.ndhb.pycare.registration.aggregate.RegistrationType;

@Data
@NoArgsConstructor
public class RegistrationTypeDTO {
    private RegistrationType RegistrationType;

}
