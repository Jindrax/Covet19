package com.javeriana.web.four.covet19.Usuarios.User.Application.UpdateUser;

import com.javeriana.web.four.covet19.Shared.Domain.Persona.ValueObjects.*;
import com.javeriana.web.four.covet19.Usuarios.User.Application.UserValidateWords.UserValidateWords;
import com.javeriana.web.four.covet19.Usuarios.User.Domain.Exceptions.UserNotExist;
import com.javeriana.web.four.covet19.Usuarios.User.Domain.Ports.UserRepository;
import com.javeriana.web.four.covet19.Usuarios.User.Domain.Ports.ValidateWordService;
import com.javeriana.web.four.covet19.Usuarios.User.Domain.User;

import java.util.Optional;

public class UpdateUser {
    private final UserRepository repository;
    private final ValidateWordService service;
    private final UserValidateWords validator;

    public UpdateUser(UserRepository repository, ValidateWordService service) {
        this.repository = repository;
        this.service = service;
        this.validator = new UserValidateWords(service);
    }

    public void execute(
            String id,
            String nombre,
            String password,
            String correo,
            Long telefono,
            Long cedula,
            String direccion,
            String fechaNacimiento
    ) {
        Optional<User> user = repository.find(id);
        if (user.isEmpty())
        {
            throw new UserNotExist("The user " + id + " not exists");
        }
        User userTemp = user.get();
        validator.execute(new NombrePersona(nombre).value());
        userTemp.update(
                new User(
                        new IdPersona(id),
                        new NombrePersona(nombre),
                        new PasswordPersona(password),
                        new CorreoPersona(correo),
                        new TelefonoPersona(telefono),
                        new CedulaPersona(cedula),
                        new DireccionPersona(direccion),
                        new FechaNacimientoPersona(fechaNacimiento),
                        null,
                        null));
        repository.update(null,userTemp);
    }
}
