# Jmix REST DataStore Compatibility Sample

The Service app is based on Jmix 1.6 and exposes `Customer` entity through the Generic REST.

The Client app is based on Jmix 2.5 and consumes the Service's `Customer` data using REST DataStore.

## Running the sample

1. Open the `client-app` and `service-app` folders as separate projects in the IDE. Due to different Jmix versions they cannot work in a single composite project.
1. Run the `service-app` application.
1. Open `http://localhost:8081/` in your browser, login as `admin` / `admin`. 
1. Create a new User with the `integration` name and `integration` password. Assign the `IntegrationRole` to this user.
1. Run the `client-app` application.
1. Open `http://localhost:8080/` in your browser, login as `admin` / `admin`.
1. Now you can manage Customers and Regions both in the Client and in the Service applications.

## Implementation details

1. Jmix 1.x REST API supports only the Password grant, so the Client authenticates in the Service as a special "integration user". This user must be created in the Service with minimal permissions required for the integration.

1. The Client app uses the standard `restds_RestPasswordAuthenticator`, but custom `RestTokenHolder` implementation that stores the token of the integration user: [IntegrationTokenHolder](client-app/src/main/java/com/company/clientapp/security/IntegrationTokenHolder.java). All Service invocations use the same token.

1. The [IntegrationInitializer](client-app/src/main/java/com/company/clientapp/security/IntegrationInitializer.java) class authenticates in the Service on the Client application start using the "integration user" credentials obtained from the environment.

1. Jmix 1.x uses non-standard path for obtaining tokens, so the Client includes the following property: `serviceapp.tokenPath=/oauth/token`

1. The `jmix.restds.authentication-provider-store` property that provides authentication of the current user in the service must not be present the environment.

1. Jmix 1.x REST API does not support inline fetch plans. Therefore, the Service and the Client define the same `customer-with-region` fetch plan in their [fetch-plans.xml](client-app/src/main/resources/com/company/clientapp/fetch-plans.xml) files. This fetch plan's name is used in the Client views for the `Customer` entity.  