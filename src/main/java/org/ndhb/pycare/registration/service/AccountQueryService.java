package org.ndhb.pycare.registration.service;

import static org.ndhb.pycare.registration.service.ServiceUtils.formatUuid;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

import org.axonframework.eventsourcing.eventstore.EventStore;
import org.axonframework.messaging.Message;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.ndhb.pycare.registration.entity.Account;
import org.ndhb.pycare.registration.query.FindAccountQuery;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class AccountQueryService {
    private final QueryGateway queryGateway;
    private final EventStore eventStore;

    public CompletableFuture<Account> findById(String accountId) {
        return this.queryGateway.query(
                new FindAccountQuery(formatUuid(accountId)),
                ResponseTypes.instanceOf(Account.class)
        );
    }

    public List<Object> listEventsForAccount(String accountId) {
        return this.eventStore
                .readEvents(formatUuid(accountId).toString())
                .asStream()
                .map(Message::getPayload)
                .collect(Collectors.toList());
    }
}
