package com.javeriana.web.four.covet19.Usuarios.User.Domain.Exceptions;

public class ElementoCarritoNotExist extends RuntimeException{

    public ElementoCarritoNotExist(String id) {
        super("El producto con id: " + id + "no existe en el carrito");
    }
}

