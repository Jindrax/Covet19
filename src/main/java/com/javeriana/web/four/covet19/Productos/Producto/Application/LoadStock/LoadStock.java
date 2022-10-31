package com.javeriana.web.four.covet19.Productos.Producto.Application.LoadStock;

import com.javeriana.web.four.covet19.Productos.Producto.Application.Exceptions.NotFound;
import com.javeriana.web.four.covet19.Productos.Producto.Application.Find.FindProducto;
import com.javeriana.web.four.covet19.Productos.Producto.Domain.Producto;
import com.javeriana.web.four.covet19.Productos.Producto.Infrastructure.Hibernate.HibernateProductoRepository;

import java.util.Optional;

public class LoadStock {
    private final HibernateProductoRepository repository;
    private final FindProducto finder;

    public LoadStock(HibernateProductoRepository repository, FindProducto finder) {
        this.repository = repository;
        this.finder = finder;
    }

    public void execute(String id, int stock) throws NotFound {
        Optional<Producto> producto = finder.execute(id);
        if (producto.isPresent()) {
            producto.get().loadStock(stock);
            repository.update(producto.get());
        } else {
            throw new NotFound("Producto no encontrado");
        }
    }
}
