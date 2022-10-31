package com.javeriana.web.four.covet19.Productos.Producto.Domain.Ports;

import com.javeriana.web.four.covet19.Productos.Producto.Domain.Producto;

import java.util.List;
import java.util.Optional;

public interface ProductoRepository {
    void update(Producto producto);

    Optional<Producto> find(String productoId);

    void save(Producto producto);

    Optional<List<Producto>> all();

    Optional<List<Producto>> allLike(String nombre);
}
