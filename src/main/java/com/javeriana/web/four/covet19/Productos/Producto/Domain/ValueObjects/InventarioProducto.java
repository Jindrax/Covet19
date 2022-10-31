package com.javeriana.web.four.covet19.Productos.Producto.Domain.ValueObjects;

import com.javeriana.web.four.covet19.Productos.Producto.Domain.Exceptions.NegativeValue;
import com.javeriana.web.four.covet19.Shared.Domain.IntegerValueObject;

public class InventarioProducto extends IntegerValueObject {

    public InventarioProducto(int value) {
        this.validate(value);
        this.value = value;
    }

    public InventarioProducto() {
    }

    public void validate(int value) {
        if (value < 0) {
            throw new NegativeValue("Unidades negativas invalidas");
        }
    }
}
