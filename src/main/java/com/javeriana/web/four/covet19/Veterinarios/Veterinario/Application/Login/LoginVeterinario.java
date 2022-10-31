package com.javeriana.web.four.covet19.Veterinarios.Veterinario.Application.Login;

import com.javeriana.web.four.covet19.Shared.Domain.Login.LoginExecutor;
import com.javeriana.web.four.covet19.Shared.Domain.Security.Auth.AuthEntity;
import com.javeriana.web.four.covet19.Veterinarios.Veterinario.Application.Find.VeterinarioFinder;

public class LoginVeterinario implements LoginExecutor {

    VeterinarioFinder veterinarioFinder;

    public LoginVeterinario(VeterinarioFinder veterinarioFinder) {
        this.veterinarioFinder = veterinarioFinder;
    }

    @Override
    public AuthEntity execute(String id) {
        return veterinarioFinder.execute(id);
    }
}
