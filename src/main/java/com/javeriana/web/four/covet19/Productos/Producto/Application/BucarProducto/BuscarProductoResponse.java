package com.javeriana.web.four.covet19.Productos.Producto.Application.BucarProducto;

import com.javeriana.web.four.covet19.Productos.Producto.Domain.Producto;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class BuscarProductoResponse {
    private final List<Producto> productos;

    public BuscarProductoResponse(List<Producto> productos) {
        this.productos = productos;
    }

    public List<HashMap> response(){
        List<HashMap> response = productos.stream().map(p -> p.data()).collect(Collectors.toList());
        return response;
    }
}
