package com.javeriana.web.four.covet19.Productos.Producto.Domain.ValueObjects;

import com.javeriana.web.four.covet19.Productos.Producto.Domain.Exceptions.NonValue;
import com.javeriana.web.four.covet19.Shared.Domain.StringValueObject;

public class MarcaProducto extends StringValueObject {
    public MarcaProducto(String value) {
        this.validate(value);
        this.value = value;
    }

    public MarcaProducto() {
    }

    public void validate(String value){
        if(value.equals("")){
            throw new NonValue("La marca no puede estar vacia");
        }
    }
}
