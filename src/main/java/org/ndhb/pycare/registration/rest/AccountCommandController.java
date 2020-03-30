package org.ndhb.pycare.registration.rest;

import static org.springframework.http.HttpStatus.CREATED;

import java.util.concurrent.CompletableFuture;

import javax.validation.Valid;

import org.ndhb.pycare.registration.aggregate.RegistrationType;
import org.ndhb.pycare.registration.entity.Account;
import org.ndhb.pycare.registration.rest.dto.AccountCreationDTO;
import org.ndhb.pycare.registration.rest.dto.RegistrationTypeDTO;
import org.ndhb.pycare.registration.rest.dto.StatusDTO;
import org.ndhb.pycare.registration.service.AccountCommandService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping(value = "/accounts")
@AllArgsConstructor
public class AccountCommandController {
    private final AccountCommandService accountCommandService;

    @PostMapping
    @ResponseStatus(value = CREATED)
    public CompletableFuture<Account> createAccount(@Valid @RequestBody AccountCreationDTO creationDTO) {
    	
        return this.accountCommandService.createAccount(creationDTO);
    }
    
    @PutMapping(value = "/{accountId}")
    public CompletableFuture<Account> updateAccount(@PathVariable(value = "accountId") String accountId,@RequestBody AccountCreationDTO updateDTO) {
        return this.accountCommandService.updateAccount(accountId, updateDTO);
    }

   

    @PutMapping(value = "/status/{accountId}")
    public CompletableFuture<String> updateStatus(@PathVariable(value = "accountId") String accountId,
                                                          @RequestBody StatusDTO statusDTO) {
        return this.accountCommandService.updateStatus(accountId, statusDTO);
    }

    @PutMapping(value = "/registrationtype/{accountId}")
    public CompletableFuture<String> updateRegistrationType(@PathVariable(value = "accountId") String accountId,
                                                           @RequestBody RegistrationTypeDTO registrationTypeDTO) {
        return this.accountCommandService.updateRegistrationType(accountId, registrationTypeDTO);
    }
}
