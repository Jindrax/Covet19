package com.javeriana.web.four.covet19.Productos.Producto.Domain.ValueObjects;

import com.javeriana.web.four.covet19.Productos.Producto.Domain.Exceptions.NegativeValue;
import com.javeriana.web.four.covet19.Shared.Domain.DoubleValueObject;

public class PrecioProducto extends DoubleValueObject {

    public PrecioProducto(double value) {
        this.validate(value);
        this.value = value;
    }

    public PrecioProducto() {
    }

    public void validate(double value){
        if(value<0){
            throw new NegativeValue("Valor negativo invalido");
        }
    }
}
