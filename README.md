## Jmix REST DataStore Compatibility Sample

Service app is based on Jmix 1.6 and exposes `Customer` entity through the Generic REST.

Client app is based on Jmix 2.5 and consumes the Service's `Customer` data using REST DataStore.

The Client authenticates in the Service as a special "integration user". This user is defined in the Service with minimal permissions required for the integration.

The Client app uses the standard `restds_RestPasswordAuthenticator`, but custom `RestTokenHolder` implementation that stores the token of the integration user: [IntegrationTokenHolder](client-app/src/main/java/com/company/clientapp/security/IntegrationTokenHolder.java). All Service invocations use the same token.

The [IntegrationInitializer](client-app/src/main/java/com/company/clientapp/security/IntegrationInitializer.java) class authenticates in the Service on the Client application start using the "integration user" credentials obtained from the environment.

The `jmix.restds.authentication-provider-store` property that provides authentication of the current user in the service must not be present the environment.
