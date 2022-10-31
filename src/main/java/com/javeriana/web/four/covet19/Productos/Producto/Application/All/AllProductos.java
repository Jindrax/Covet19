package com.javeriana.web.four.covet19.Productos.Producto.Application.All;

import com.javeriana.web.four.covet19.Productos.Producto.Domain.Ports.ProductoRepository;
import com.javeriana.web.four.covet19.Productos.Producto.Domain.Producto;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class AllProductos {

    private final ProductoRepository repository;

    public AllProductos(ProductoRepository repository) {
        this.repository = repository;
    }

    public List<Producto> execute(){
        Optional<List<Producto>> productos = repository.all();
        return productos.orElseGet(ArrayList::new);
    }

}
