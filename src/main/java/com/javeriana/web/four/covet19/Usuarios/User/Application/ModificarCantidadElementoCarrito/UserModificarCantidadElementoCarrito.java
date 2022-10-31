package com.javeriana.web.four.covet19.Usuarios.User.Application.ModificarCantidadElementoCarrito;

import com.javeriana.web.four.covet19.Usuarios.User.Domain.Exceptions.UserNotExist;
import com.javeriana.web.four.covet19.Usuarios.User.Domain.Ports.UserRepository;
import com.javeriana.web.four.covet19.Usuarios.User.Domain.User;
import com.javeriana.web.four.covet19.Usuarios.User.Domain.ValueObjects.ElementoCarritoUsuario;

import java.util.Optional;

public class UserModificarCantidadElementoCarrito {

    private final UserRepository repository;

    public UserModificarCantidadElementoCarrito(UserRepository repository) {
        this.repository = repository;
    }

    public void execute(String idUsuario, ElementoCarritoUsuario elementoCarritoUsuario, boolean esSuma)
    {
        Optional<User> usuario = repository.find(idUsuario);
        if (usuario.isEmpty())
        {
            throw new UserNotExist(idUsuario);
        }

        User finalUser = usuario.get();
        boolean delete = finalUser.updateElementoCarrito(elementoCarritoUsuario, esSuma);

        if(delete) {
            finalUser.deleteElementoCarrito(elementoCarritoUsuario);
        }

        repository.update(idUsuario, finalUser);
    }

}
