package com.javeriana.web.four.covet19.Productos.Producto.Domain.Exceptions;

public class NegativeValue extends RuntimeException{
    public NegativeValue(String message) {
        super(message);
    }
}
