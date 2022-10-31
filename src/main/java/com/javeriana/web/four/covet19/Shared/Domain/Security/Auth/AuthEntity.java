package com.javeriana.web.four.covet19.Shared.Domain.Security.Auth;

import com.javeriana.web.four.covet19.Shared.Domain.Security.Auth.Exceptions.IncorrectCredentials;

import java.util.HashMap;

public interface AuthEntity {
    AuthCredentials getCredentials(String supposedPass) throws IncorrectCredentials;
    HashMap<String, Object> dataToAuth();
}
