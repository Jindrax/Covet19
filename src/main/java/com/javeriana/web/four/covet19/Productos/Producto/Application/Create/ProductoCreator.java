package com.javeriana.web.four.covet19.Productos.Producto.Application.Create;

import com.javeriana.web.four.covet19.Productos.Producto.Domain.Ports.ProductoRepository;
import com.javeriana.web.four.covet19.Productos.Producto.Domain.Producto;
import com.javeriana.web.four.covet19.Productos.Producto.Domain.ValueObjects.DescripcionProducto;
import com.javeriana.web.four.covet19.Productos.Producto.Domain.ValueObjects.MarcaProducto;
import com.javeriana.web.four.covet19.Productos.Producto.Domain.ValueObjects.NombreProducto;
import com.javeriana.web.four.covet19.Productos.Producto.Domain.ValueObjects.PrecioProducto;
import com.javeriana.web.four.covet19.Shared.Domain.Productos.ProductoId;

public class ProductoCreator {
    private final ProductoRepository repository;

    public ProductoCreator(ProductoRepository repository) {
        this.repository = repository;
    }

    public void execute(String id, String nombre, String descripcion, Double precio, String marca ){
        repository.save(Producto.create(new ProductoId(id), new NombreProducto(nombre), new DescripcionProducto(descripcion), new PrecioProducto(precio), new MarcaProducto(marca)));
    }
}
