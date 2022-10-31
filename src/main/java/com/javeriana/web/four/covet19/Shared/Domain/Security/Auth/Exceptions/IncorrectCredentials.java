package com.javeriana.web.four.covet19.Shared.Domain.Security.Auth.Exceptions;

public class IncorrectCredentials extends RuntimeException{
    public IncorrectCredentials(String message) {
        super(message);
    }
}
