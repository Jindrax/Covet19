package com.javeriana.web.four.covet19.Usuarios.User.Application.Login;

import com.javeriana.web.four.covet19.Shared.Domain.Login.LoginExecutor;
import com.javeriana.web.four.covet19.Shared.Domain.Security.Auth.AuthEntity;
import com.javeriana.web.four.covet19.Usuarios.User.Application.Find.UserFinder;

public class LoginUser implements LoginExecutor {

    UserFinder userFinder;

    public LoginUser(UserFinder userFinder) {
        this.userFinder = userFinder;
    }

    @Override
    public AuthEntity execute(String id) {
        return userFinder.execute(id);
    }
}
