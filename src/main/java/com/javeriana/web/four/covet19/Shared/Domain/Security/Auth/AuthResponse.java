package com.javeriana.web.four.covet19.Shared.Domain.Security.Auth;

public class AuthResponse {
    AuthCredentials credentials;
    AuthEntity entity;

    public AuthResponse(AuthCredentials credentials, AuthEntity entity) {
        this.credentials = credentials;
        this.entity = entity;
    }

    public AuthCredentials getCredentials() {
        return credentials;
    }

    public AuthEntity getEntity() {
        return entity;
    }
}
