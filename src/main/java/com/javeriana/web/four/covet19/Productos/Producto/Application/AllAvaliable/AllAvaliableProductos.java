package com.javeriana.web.four.covet19.Productos.Producto.Application.AllAvaliable;

import com.javeriana.web.four.covet19.Productos.Producto.Domain.Ports.ProductoRepository;
import com.javeriana.web.four.covet19.Productos.Producto.Domain.Producto;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class AllAvaliableProductos {

    private final ProductoRepository repository;


    public AllAvaliableProductos(ProductoRepository repository) {
        this.repository = repository;
    }

    public List<Producto> execute(){
        Optional<List<Producto>> productos = repository.all();
        List<Producto> filtrados = productos.orElseGet(ArrayList::new).stream().filter(Producto::isHabilitado).collect(Collectors.toList());
        return filtrados;
    }
}
