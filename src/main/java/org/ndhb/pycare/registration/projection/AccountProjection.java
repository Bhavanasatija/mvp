package org.ndhb.pycare.registration.projection;

import java.util.Optional;

import org.axonframework.eventhandling.EventHandler;
import org.axonframework.queryhandling.QueryHandler;
import org.axonframework.queryhandling.QueryUpdateEmitter;
import org.ndhb.pycare.registration.aggregate.RegistrationType;
import org.ndhb.pycare.registration.entity.Account;
import org.ndhb.pycare.registration.event.AccountCreatedEvent;
import org.ndhb.pycare.registration.event.AccountUpdatedEvent;
import org.ndhb.pycare.registration.event.PatientLocalIdUpdatedEvent;
import org.ndhb.pycare.registration.event.RegistrationTypeChangedEvent;
import org.ndhb.pycare.registration.event.StatusUpdatedEvent;
import org.ndhb.pycare.registration.exception.AccountNotFoundException;
import org.ndhb.pycare.registration.query.FindAccountQuery;
import org.ndhb.pycare.registration.repository.AccountRepository;
import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Component
public class AccountProjection {

    private final AccountRepository repository;
    private final QueryUpdateEmitter updateEmitter;


    @EventHandler
    public void on(AccountCreatedEvent event) {
        log.debug("Handling an Account creation command {}", event.getAccountId());
        Account account = new Account(
        		event.getAccountId(),
        		event.getAlternateUniqueIdentificationNumberType(),
        		event.getAlternateUniqueIdentificationNumber(),
        		event.getPatientLocalId(),
        		event.getUhid(),
        		event.getPatientName(),
        		event.getDob(),
               // command.getPatientAge(),
        		event.getStatus(),
        		event.getRegistrationType(),
        		event.getEmail(),
        		event.getBirthOrder(),
        		event.getParity(),
        		event.getGravida(),
        		event.getIdentityUnknownIndicator(),
        		event.getCauseOfDeathKnownIndicator(),
        		event.getPatientAddressType(),
        		//event.getPatientAddress(),
        		event.getHouseNo(),
        		event.getLocality(),
        		event.getSubLocality1(),
        		event.getSubLocality2(),
        		event.getState(),
        		event.getPin(),
        		event.getPatientLandlineNumber(),
        		event.getPatientMobileNumber(),
        		event.getPatientClass(),
        		event.getPregnancyIndicator(),
        		event.getDurationOfPregnancy(),
        		event.getInsuredCardID(),
        		event.getInsuredPolicyID(),
        		event.getSecondaryHealthInsurancePolicyIndicator(),
        		event.getSecondaryHealthInsurancePolicyID()

               

                
        );
        this.repository.save(account);
    }

    
    @EventHandler
    public void on(AccountUpdatedEvent event) throws AccountNotFoundException {
        log.debug("Handling an Account update command {}", event.getAccountId());
        Optional<Account> optionalAccount = this.repository.findById(event.getAccountId());
        if (optionalAccount.isPresent()) {
            Account account = optionalAccount.get();
            account.setAlternateUniqueIdentificationNumber(event.getAlternateUniqueIdentificationNumber());
            account.setAlternateUniqueIdentificationNumberType(event.getAlternateUniqueIdentificationNumberType());
            account.setPatientName(event.getPatientName());
            account.setRegistrationType(event.getRegistrationType());
            account.setDob(event.getDob());
            account.setUhid(event.getUhid());
            account.setId(event.getAccountId());
            account.setPatientClass(event.getPatientClass());
            account.setCauseOfDeathKnownIndicator(event.getCauseOfDeathKnownIndicator());
            account.setBirthOrder(event.getBirthOrder());
            account.setDurationOfPregnancy(event.getDurationOfPregnancy());
            //account.setPatientAddress(event.getPatientAddress());
            account.setHouseNo( event.getHouseNo());
            account.setLocality(event.getLocality());
            account.setSubLocality1(event.getSubLocality1());
            account.setSubLocality2(event.getSubLocality2());
            account.setState(event.getState());
            account.setPin(event.getPin());
            account.setPatientAddressType(event.getPatientAddressType());
            account.setPatientLandlineNumber(event.getPatientLandlineNumber());
            account.setPatientMobileNumber(event.getPatientMobileNumber());
            account.setPregnancyIndicator(event.getPregnancyIndicator());
            account.setInsuredPolicyID(event.getInsuredCardID());
            account.setParity(event.getParity());
            account.setGravida(event.getGravida());
            account.setEmail(event.getEmail());
            account.setBirthOrder(event.getBirthOrder());
            account.setInsuredCardID(event.getInsuredCardID());
            account.setSecondaryHealthInsurancePolicyID(event.getSecondaryHealthInsurancePolicyID());
            account.setSecondaryHealthInsurancePolicyIndicator(event.getSecondaryHealthInsurancePolicyIndicator());



  
        this.repository.save(account);
        } else {
            throw new AccountNotFoundException(event.getAccountId());
        }
    }
    
    @EventHandler
    public void on(StatusUpdatedEvent event) throws AccountNotFoundException {
        log.debug("Handling a Status updated command {}", event.getId());
        Optional<Account> optionalAccount = this.repository.findById(event.getId());
        if (optionalAccount.isPresent()) {
            Account account = optionalAccount.get();
            account.setStatus(event.getStatus());
            this.repository.save(account);
        } else {
            throw new AccountNotFoundException(event.getId());
        }
    }

    @EventHandler
    public void on(PatientLocalIdUpdatedEvent event) throws AccountNotFoundException {
        log.debug("Handling a Status updated command {}", event.getId());
        Optional<Account> optionalAccount = this.repository.findById(event.getId());
        if (optionalAccount.isPresent()) {
            Account account = optionalAccount.get();
            account.setPatientLocalId(event.getPatientLocalId());
            this.repository.save(account);
        } else {
            throw new AccountNotFoundException(event.getId());
        }
    }

    

    @EventHandler
    public void on(RegistrationTypeChangedEvent event) throws AccountNotFoundException {
        log.debug("Handling a update RegistrationTypecommand {}", event.getId());
        Optional<Account> optionalAccount = this.repository.findById(event.getId());
        if (optionalAccount.isPresent()) {
            Account account = optionalAccount.get();
            account.setRegistrationType(event.getRegistrationType());
            if(event.getRegistrationType()==RegistrationType.WALKIN) {
            account.setPatientLocalId(account.getPatientLocalId().replaceFirst("TEMP", "RTWO-"));
            }else {
            	account.setPatientLocalId(account.getPatientLocalId().replaceFirst("RTWO-", "TEMP-"));
            }
            this.repository.save(account);
        } else {
            throw new AccountNotFoundException(event.getId());
        }
    }

    @QueryHandler
    public Account handle(FindAccountQuery query) {
        log.debug("Handling FindAccountQuery query: {}", query);
        return this.repository.findById(query.getAccountId()).orElse(null);
    }
}
