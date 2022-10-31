package com.javeriana.web.four.covet19.Usuarios.User.Application.Find;

import com.javeriana.web.four.covet19.Shared.Domain.Persona.ValueObjects.IdPersona;
import com.javeriana.web.four.covet19.Usuarios.User.Application.UserDomainFinder.UserDomainFinder;
import com.javeriana.web.four.covet19.Usuarios.User.Domain.Ports.UserRepository;
import com.javeriana.web.four.covet19.Usuarios.User.Domain.User;

import java.util.Optional;

public class UserFinder {

    private final UserDomainFinder finder;

    public UserFinder(UserRepository repository) {
        this.finder = new UserDomainFinder(repository);
    }

    public User execute(String userId) {
        Optional<User> user = finder.execute(new IdPersona(userId).value());
        return user.get();
    }
}
