package com.company.clientapp.security;

import io.jmix.restds.impl.RestTokenHolder;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Primary
@Component
public class IntegrationTokenHolder implements RestTokenHolder {

    private String accessToken;
    private String refreshToken;

    @Override
    public String getAccessToken() {
        return accessToken;
    }

    @Override
    public String getRefreshToken() {
        return refreshToken;
    }

    @Override
    public void setTokens(String accessToken, String refreshToken) {
        this.accessToken = accessToken;
        this.refreshToken = refreshToken;
    }
}
