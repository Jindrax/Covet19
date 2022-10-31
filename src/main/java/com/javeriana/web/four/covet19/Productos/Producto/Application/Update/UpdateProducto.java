package com.javeriana.web.four.covet19.Productos.Producto.Application.Update;

import com.javeriana.web.four.covet19.Productos.Producto.Application.Exceptions.NotFound;
import com.javeriana.web.four.covet19.Productos.Producto.Application.Find.FindProducto;
import com.javeriana.web.four.covet19.Productos.Producto.Domain.Producto;
import com.javeriana.web.four.covet19.Productos.Producto.Infrastructure.Controllers.UpdateProductoRequest;
import com.javeriana.web.four.covet19.Productos.Producto.Infrastructure.Hibernate.HibernateProductoRepository;

import java.util.Optional;

public class UpdateProducto {
    private final HibernateProductoRepository repository;

    public UpdateProducto(HibernateProductoRepository repository) {
        this.repository = repository;
    }

    public void execute(UpdateProductoRequest updateProductoRequest){
        if(updateProductoRequest.getId().isEmpty()){
            throw new NotFound("Falta el id del producto");
        }
        Optional<Producto> producto = new FindProducto(repository).execute(updateProductoRequest.getId().get());
        if(producto.isEmpty()){
            throw new NotFound("Producto no encontrado");
        }
        if(updateProductoRequest.getNombre().isPresent()){
            producto.get().updateNombreProducto(updateProductoRequest.getNombre().get());
        }
        if(updateProductoRequest.getDescripcion().isPresent()){
            producto.get().updateDescripcionProducto(updateProductoRequest.getDescripcion().get());
        }
        if(updateProductoRequest.getPrecio().isPresent()){
            producto.get().updatePrecioProducto(updateProductoRequest.getPrecio().get());
        }
        if(updateProductoRequest.getMarca().isPresent()){
            producto.get().updateMarcaProducto(updateProductoRequest.getMarca().get());
        }
        repository.update(producto.get());
    }
}
