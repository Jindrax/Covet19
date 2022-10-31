package com.javeriana.web.four.covet19.Productos.Producto.Application.Find;

import com.javeriana.web.four.covet19.Productos.Producto.Domain.Producto;
import com.javeriana.web.four.covet19.Productos.Producto.Infrastructure.Hibernate.HibernateProductoRepository;

import java.util.Optional;

public class FindProducto {
    private final HibernateProductoRepository repository;

    public FindProducto(HibernateProductoRepository repository) {
        this.repository = repository;
    }

    public Optional<Producto> execute(String productoId){
        return this.repository.find(productoId);
    }
}
