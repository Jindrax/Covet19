package com.javeriana.web.four.covet19.Productos.Producto.Domain.ValueObjects;

import com.javeriana.web.four.covet19.Productos.Producto.Domain.Exceptions.NonValue;
import com.javeriana.web.four.covet19.Shared.Domain.StringValueObject;

public class DescripcionProducto extends StringValueObject {
    public DescripcionProducto() {
    }

    public DescripcionProducto(String value) {
        this.validate(value);
        this.value = value;
    }

    public void validate(String value) {
        if (value.equals("")) {
            throw new NonValue("El nombre no puede estar vacio");
        }
    }
}
