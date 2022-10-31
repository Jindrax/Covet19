package com.javeriana.web.four.covet19.Productos.Producto.Domain.ValueObjects;

import com.javeriana.web.four.covet19.Shared.Domain.BooleanValueObject;

public class HabilitadoProducto extends BooleanValueObject {

    public HabilitadoProducto() {
    }

    public HabilitadoProducto(boolean value) {
        this.validate(value);
        this.value = value;
    }

    public void validate(boolean value) {

    }
}
