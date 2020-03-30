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
import org.ndhb.pycare.registration.exception.DuplicateDataException;
import org.ndhb.pycare.registration.exception.ResponseError;
import org.ndhb.pycare.registration.repository.AccountRepository;
import org.ndhb.pycare.registration.rest.dto.AccountCreationDTO;
import org.ndhb.pycare.registration.rest.dto.AccountUpdateDTO;
import org.ndhb.pycare.registration.rest.dto.PatientLocalIdDTO;
import org.ndhb.pycare.registration.rest.dto.RegistrationTypeDTO;
import org.ndhb.pycare.registration.rest.dto.StatusDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.ExampleMatcher.GenericPropertyMatchers;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class AccountCommandService {
	@Autowired
	private AccountRepository accountRepository;

	private final CommandGateway commandGateway;
	private static AtomicInteger atomicInteger = new AtomicInteger(200);

	public CompletableFuture<Account> createAccount(AccountCreationDTO creationDTO) {
		
		
		if(accountRepository.existsByEmail(creationDTO.getEmail())) throw new IllegalArgumentException(" User Already Exist with same email id");
		
		
			
	
		String prefix = "TEMP";
		if (creationDTO.getRegistrationType() == (RegistrationType.WALKIN))
			prefix = "RTWO-";
		return this.commandGateway
				.send(new CreateAccountCommand(
						
						UUID.randomUUID(), 
						prefix + atomicInteger.incrementAndGet(),
						creationDTO.getUhid(),
						creationDTO.getAlternateUniqueIdentificationNumberType(),
						creationDTO.getAlternateUniqueIdentificationNumber(),
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
						//creationDTO.getPatientAddress(),
						creationDTO.getHouseNo(),
						creationDTO.getLocality(),
						creationDTO.getSubLocality1(),
						creationDTO.getSubLocality2(),
						creationDTO.getState(),
						creationDTO.getPin(),
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

	public CompletableFuture<Account> updateAccount(String accountId, AccountUpdateDTO updateDTO) {
		return this.commandGateway.send(new UpdateAccountCommand(
				formatUuid(accountId),
				updateDTO.getUhid(),
				updateDTO.getAlternateUniqueIdentificationNumberType(),
				updateDTO.getAlternateUniqueIdentificationNumber(),
				updateDTO.getPatientName(),
				updateDTO.getStatus(),
				updateDTO.getRegistrationType(),
				updateDTO.getEmail(),
				updateDTO.getDob(),
				updateDTO.getBirthOrder(),
				updateDTO.getParity(),
				updateDTO.getGravida(),
				updateDTO.getIdentityUnknownIndicator(),
				updateDTO.getCauseOfDeathKnownIndicator(),
				updateDTO.getPatientAddressType(),
				//creationDTO.getPatientAddress(),
				updateDTO.getHouseNo(),
				updateDTO.getLocality(),
				updateDTO.getSubLocality1(),
				updateDTO.getSubLocality2(),
				updateDTO.getState(),
				updateDTO.getPin(),
				updateDTO.getPatientLandlineNumber(),
				updateDTO.getPatientMobileNumber(),
				updateDTO.getPatientClass(),
        		updateDTO.getPregnancyIndicator(),
        		updateDTO.getDurationOfPregnancy(),
        		updateDTO.getInsuredCardID(),
        		updateDTO.getInsuredPolicyID(),
        		updateDTO.getSecondaryHealthInsurancePolicyID(),
        		updateDTO.getSecondaryHealthInsurancePolicyIndicator()

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
