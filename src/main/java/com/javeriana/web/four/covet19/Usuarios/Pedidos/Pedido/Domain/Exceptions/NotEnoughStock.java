package com.javeriana.web.four.covet19.Usuarios.Pedidos.Pedido.Domain.Exceptions;

public class NotEnoughStock extends RuntimeException{
    public NotEnoughStock(String message) {
        super(message);
    }
}
