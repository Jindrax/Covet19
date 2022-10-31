package com.javeriana.web.four.covet19.Usuarios.User.Application.Update;

import com.javeriana.web.four.covet19.Shared.Domain.Persona.ValueObjects.NombrePersona;
import com.javeriana.web.four.covet19.Usuarios.User.Application.UserDomainFinder.UserDomainFinder;
import com.javeriana.web.four.covet19.Usuarios.User.Application.UserValidateWords.UserValidateWords;
import com.javeriana.web.four.covet19.Usuarios.User.Domain.Ports.UserRepository;
import com.javeriana.web.four.covet19.Usuarios.User.Domain.Ports.ValidateWordService;
import com.javeriana.web.four.covet19.Usuarios.User.Domain.User;

import java.util.Optional;

public class UserModifier {

    private final UserRepository repository;
    private final UserDomainFinder finder;
    private final UserValidateWords validator;
    private final ValidateWordService service;

    public UserModifier(UserRepository repository, ValidateWordService service) {
        this.repository = repository;
        this.service = service;
        this.finder = new UserDomainFinder(repository);
        this.validator = new UserValidateWords(service);
    }

    public void execute(String userId, String userFirstName)
    {
        validator.execute(new NombrePersona(userFirstName).value());
        Optional<User> actualUser = finder.execute(userId);
        User oldUser = actualUser.get();
        oldUser.updateUser(new NombrePersona(userFirstName));
        repository.update(userId, oldUser);
    }
}
