package com.javeriana.web.four.covet19.Shared.Domain.Login;

import com.javeriana.web.four.covet19.Shared.Domain.Security.Auth.AuthEntity;

public interface LoginExecutor {
    public AuthEntity execute(String id);
}
