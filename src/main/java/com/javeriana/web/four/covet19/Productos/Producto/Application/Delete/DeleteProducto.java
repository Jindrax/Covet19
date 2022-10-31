package com.javeriana.web.four.covet19.Productos.Producto.Application.Delete;

import com.javeriana.web.four.covet19.Productos.Producto.Application.Exceptions.NotFound;
import com.javeriana.web.four.covet19.Productos.Producto.Application.Find.FindProducto;
import com.javeriana.web.four.covet19.Productos.Producto.Domain.Producto;
import com.javeriana.web.four.covet19.Productos.Producto.Infrastructure.Hibernate.HibernateProductoRepository;

import java.util.Optional;

public class DeleteProducto {
    private final HibernateProductoRepository repository;

    public DeleteProducto(HibernateProductoRepository repository) {
        this.repository = repository;
    }

    public void execute(String id){
        Optional<Producto> producto = new FindProducto(repository).execute(id);
        if(producto.isEmpty()){
            throw new NotFound("Producto no encontrado");
        }
        producto.get().deshabilitarProducto();
        repository.update(producto.get());
    }


}
