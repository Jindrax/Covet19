package com.javeriana.web.four.covet19.Shared.Application;

import com.javeriana.web.four.covet19.Admins.Admin.Application.Login.LoginAdmin;
import com.javeriana.web.four.covet19.Admins.Admin.Domain.Admin;
import com.javeriana.web.four.covet19.Productos.Producto.Application.Exceptions.NotFound;
import com.javeriana.web.four.covet19.Shared.Domain.Index.Domain.Index;
import com.javeriana.web.four.covet19.Shared.Domain.Index.Domain.Ports.IndexRepository;
import com.javeriana.web.four.covet19.Shared.Domain.Login.LoginExecutor;
import com.javeriana.web.four.covet19.Shared.Domain.Security.Auth.AuthCredentials;
import com.javeriana.web.four.covet19.Shared.Domain.Security.Auth.AuthEntity;
import com.javeriana.web.four.covet19.Shared.Domain.Security.Auth.AuthResponse;
import com.javeriana.web.four.covet19.Usuarios.User.Application.Login.LoginUser;
import com.javeriana.web.four.covet19.Usuarios.User.Domain.User;
import com.javeriana.web.four.covet19.Veterinarios.Veterinario.Application.Login.LoginVeterinario;
import com.javeriana.web.four.covet19.Veterinarios.Veterinario.Domain.Veterinario;

import java.util.HashMap;
import java.util.Optional;

public class Login {

    IndexRepository repository;
    HashMap<String, LoginExecutor> executor;

    public Login(IndexRepository repository, LoginAdmin admin, LoginUser user, LoginVeterinario veterinario) {
        this.repository = repository;
        this.executor = new HashMap<>() {{
            put(Admin.class.getName(), admin);
            put(User.class.getName(), user);
            put(Veterinario.class.getName(), veterinario);
        }};
    }

    public AuthResponse execute(String email, String pass) throws NotFound {
        Optional<Index> indexOptional = repository.find(email);
        if (indexOptional.isPresent()) {
            Index index = indexOptional.get();
            AuthEntity authEntity = executor.get(index.getRolValueObject()).execute(index.getRefererenceValueObject());
            AuthCredentials credentials = authEntity.getCredentials(pass);
            return new AuthResponse(credentials, authEntity);
        } else {
            throw new NotFound("Email no registrado");
        }
    }

}
