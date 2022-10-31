package com.javeriana.web.four.covet19.Usuarios.User.Application.EliminarElementoCarrito;

import com.javeriana.web.four.covet19.Usuarios.User.Domain.Exceptions.UserNotExist;
import com.javeriana.web.four.covet19.Usuarios.User.Domain.Ports.UserRepository;
import com.javeriana.web.four.covet19.Usuarios.User.Domain.User;
import com.javeriana.web.four.covet19.Usuarios.User.Domain.ValueObjects.ElementoCarritoUsuario;

import java.util.Optional;

public class UserEliminarElementoCarrito {

    private final UserRepository repository;

    public UserEliminarElementoCarrito(UserRepository repository) {
        this.repository = repository;
    }

    public void execute(String idUsuario, String idProducto)
    {
        Optional<User> usuario = repository.find(idUsuario);
        if (usuario.isEmpty())
        {
            throw new UserNotExist(idUsuario);
        }
        User finalUser = usuario.get();
        finalUser.deleteElementoCarrito(ElementoCarritoUsuario.createProductId(idProducto));
        repository.update(idUsuario, finalUser);
    }

}
