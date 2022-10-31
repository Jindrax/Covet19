package com.javeriana.web.four.covet19.Productos.Producto.Application.CanConsume;

import com.javeriana.web.four.covet19.Productos.Producto.Application.Exceptions.NotFound;
import com.javeriana.web.four.covet19.Productos.Producto.Application.Find.FindProducto;
import com.javeriana.web.four.covet19.Productos.Producto.Domain.Producto;

import java.util.Optional;

public class CanConsumeProducto {

    private FindProducto findProducto;

    public CanConsumeProducto(FindProducto findProducto) {
        this.findProducto = findProducto;
    }

    public boolean execute(String id, int quantity){
        Optional<Producto> producto = findProducto.execute(id);
        if(producto.isPresent()){
            return producto.get().isThereStock(quantity);
        }else {
            throw new NotFound("Producto no encontrado");
        }
    }
}
