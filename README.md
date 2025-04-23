## Jmix REST DataStore Compatibility Sample

Service app is based on Jmix 1.6 and exposes `Customer` entity through the Generic REST.

Client app is based on Jmix 2.5 and consumes the Service's `Customer` data using REST DataStore.

Jmix 1.x REST API supports only the Password grant, so the Client authenticates in the Service as a special "integration user". This user is defined in the Service with minimal permissions required for the integration.

The Client app uses the standard `restds_RestPasswordAuthenticator`, but custom `RestTokenHolder` implementation that stores the token of the integration user: [IntegrationTokenHolder](client-app/src/main/java/com/company/clientapp/security/IntegrationTokenHolder.java). All Service invocations use the same token.

The [IntegrationInitializer](client-app/src/main/java/com/company/clientapp/security/IntegrationInitializer.java) class authenticates in the Service on the Client application start using the "integration user" credentials obtained from the environment.

Jmix 1.x uses non-standard path for obtaining tokens, so the Client includes the following property: `serviceapp.tokenPath=/oauth/token`

The `jmix.restds.authentication-provider-store` property that provides authentication of the current user in the service must not be present the environment.

ATTENTION: open `client-app` and `service-app` folders as separate projects in the IDE. Due to different Jmix versions they cannot work in a single composite project.