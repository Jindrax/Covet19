package com.javeriana.web.four.covet19.Productos.Producto.Application.BucarProducto;

import com.javeriana.web.four.covet19.Productos.Producto.Domain.Ports.ProductoRepository;
import com.javeriana.web.four.covet19.Productos.Producto.Domain.Producto;

import java.util.List;
import java.util.Optional;

public class BuscarProducto {
    private final ProductoRepository repository;

    public BuscarProducto(ProductoRepository repository) {
        this.repository = repository;
    }
    public List<Producto> execute(String nombreBusqueda){
        Optional<List<Producto>> productos = repository.allLike(nombreBusqueda);
        if(productos.isEmpty()){
            throw new RuntimeException("Error buscando Producto");
        }
        return productos.get();
    }
}
