package org.ndhb.pycare.registration.service;

import static org.ndhb.pycare.registration.service.ServiceUtils.formatUuid;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicInteger;

import org.axonframework.commandhandling.gateway.CommandGateway;
import org.ndhb.pycare.registration.aggregate.RegistrationType;
import org.ndhb.pycare.registration.command.CreateAccountCommand;
import org.ndhb.pycare.registration.command.UpdateAccountCommand;
import org.ndhb.pycare.registration.command.UpdatePatientLocalIdCommand;
import org.ndhb.pycare.registration.command.UpdateRegistrationTypeCommand;
import org.ndhb.pycare.registration.command.UpdateStatusCommand;
import org.ndhb.pycare.registration.entity.Account;
import org.ndhb.pycare.registration.rest.dto.AccountCreationDTO;
import org.ndhb.pycare.registration.rest.dto.PatientLocalIdDTO;
import org.ndhb.pycare.registration.rest.dto.RegistrationTypeDTO;
import org.ndhb.pycare.registration.rest.dto.StatusDTO;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class AccountCommandService {
	private final CommandGateway commandGateway;
	private static AtomicInteger atomicInteger = new AtomicInteger(200);

	public CompletableFuture<Account> createAccount(AccountCreationDTO creationDTO) {
		String prefix = "TEMP";
		if (creationDTO.getRegistrationType() == (RegistrationType.WALKIN))
			prefix = "RTWO-";
		return this.commandGateway
				.send(new CreateAccountCommand(
						
						UUID.randomUUID(), 
						prefix + atomicInteger.incrementAndGet(),
						creationDTO.getUhid(),
						creationDTO.getPatientName(),
						creationDTO.getStatus(),
						creationDTO.getRegistrationType(),
						creationDTO.getEmail(),
						creationDTO.getDob(),
						creationDTO.getBirthOrder(),
						creationDTO.getParity(),
						creationDTO.getGravida(),
						creationDTO.getIdentityUnknownIndicator(),
						creationDTO.getCauseOfDeathKnownIndicator(),
						creationDTO.getPatientAddressType(),
						creationDTO.getPatientAddress(),
						creationDTO.getPatientLandlineNumber(),
		        		creationDTO.getPatientMobileNumber(),
		        		creationDTO.getPatientClass(),
		        		creationDTO.getPregnancyIndicator(),
		        		creationDTO.getDurationOfPregnancy(),
		        		creationDTO.getInsuredCardID(),
		        		creationDTO.getInsuredPolicyID(),
		        		creationDTO.getSecondaryHealthInsurancePolicyID(),
		        		creationDTO.getSecondaryHealthInsurancePolicyIndicator()

		     

				));
	}

	public CompletableFuture<Account> updateAccount(String accountId, AccountCreationDTO creationDTO) {
		return this.commandGateway.send(new UpdateAccountCommand(
				formatUuid(accountId),
				creationDTO.getUhid(),
				creationDTO.getPatientName(),
				creationDTO.getStatus(),
				creationDTO.getRegistrationType(),
				creationDTO.getEmail(),
				creationDTO.getDob(),
				creationDTO.getBirthOrder(),
				creationDTO.getParity(),
				creationDTO.getGravida(),
				creationDTO.getIdentityUnknownIndicator(),
				creationDTO.getCauseOfDeathKnownIndicator(),
				creationDTO.getPatientAddressType(),
				creationDTO.getPatientAddress(),
				creationDTO.getPatientLandlineNumber(),
        		creationDTO.getPatientMobileNumber(),
        		creationDTO.getPatientClass(),
        		creationDTO.getPregnancyIndicator(),
        		creationDTO.getDurationOfPregnancy(),
        		creationDTO.getInsuredCardID(),
        		creationDTO.getInsuredPolicyID(),
        		creationDTO.getSecondaryHealthInsurancePolicyID(),
        		creationDTO.getSecondaryHealthInsurancePolicyIndicator()

		));
	}

	public CompletableFuture<String> updateStatus(String accountId, StatusDTO statusDTO) {
		return this.commandGateway.send(new UpdateStatusCommand(formatUuid(accountId), statusDTO.getStatus()

		));
	}

	public CompletableFuture<String> updatePatientLocalId(String accountId, PatientLocalIdDTO patientLocalIdDTO) {
		return this.commandGateway.send(new UpdatePatientLocalIdCommand(formatUuid(accountId), patientLocalIdDTO.getPatientLocalId()

		));
	}

	public CompletableFuture<String> updateRegistrationType(String accountId, RegistrationTypeDTO registrationTypeDTO) {

		return this.commandGateway
				.send(new UpdateRegistrationTypeCommand(formatUuid(accountId), registrationTypeDTO.getRegistrationType()

				));
	}
}
