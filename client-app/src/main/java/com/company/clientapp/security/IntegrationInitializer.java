package com.company.clientapp.security;

import io.jmix.restds.impl.RestPasswordAuthenticator;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class IntegrationInitializer {

    @Value("${integration.store}")
    private String integrationStore;

    @Value("${integration.user.username}")
    private String integrationUser;

    @Value("${integration.user.password}")
    private String integrationPassword;

    @EventListener
    public void onApplicationStarted(final ApplicationStartedEvent event) {
        RestPasswordAuthenticator authenticator = event.getApplicationContext().getBean(RestPasswordAuthenticator.class);
        authenticator.setDataStoreName(integrationStore);
        authenticator.authenticate(integrationUser, integrationPassword);
    }
}