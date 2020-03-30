package org.ndhb.pycare.registration;

import org.axonframework.commandhandling.CommandBus;
import org.axonframework.commandhandling.SimpleCommandBus;
import org.axonframework.messaging.interceptors.BeanValidationInterceptor;

public class CommandBusConfiguration {

    public CommandBus configureCommandBus() {
        CommandBus commandBus = SimpleCommandBus.builder().build();
        commandBus.registerHandlerInterceptor(new BeanValidationInterceptor());
        return commandBus;
    }

}