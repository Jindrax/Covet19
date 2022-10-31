package com.javeriana.web.four.covet19.Admins.Admin.Application.Login;

import com.javeriana.web.four.covet19.Admins.Admin.Application.Find.FindAdmin;
import com.javeriana.web.four.covet19.Admins.Admin.Domain.Admin;
import com.javeriana.web.four.covet19.Productos.Producto.Application.Exceptions.NotFound;
import com.javeriana.web.four.covet19.Shared.Domain.Login.LoginExecutor;
import com.javeriana.web.four.covet19.Shared.Domain.Security.Auth.AuthEntity;

import java.util.Optional;

public class LoginAdmin implements LoginExecutor {

    FindAdmin findAdmin;

    public LoginAdmin(FindAdmin findAdmin) {
        this.findAdmin = findAdmin;
    }

    @Override
    public AuthEntity execute(String id) {
        Optional<Admin> admin = findAdmin.execute(id);
        if (admin.isEmpty()) {
            throw new NotFound("Administrador no encontrado");
        }
        return admin.get();
    }
}
