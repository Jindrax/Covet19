package com.javeriana.web.four.covet19.Productos.Producto.Domain;

import com.javeriana.web.four.covet19.Productos.Producto.Domain.ValueObjects.*;
import com.javeriana.web.four.covet19.Shared.Domain.Productos.ProductoId;

import java.util.HashMap;
import java.util.Objects;

public class Producto {
    private ProductoId productoId;
    private NombreProducto nombreProducto;
    private DescripcionProducto descripcionProducto;
    private PrecioProducto precioProducto;
    private MarcaProducto marcaProducto;
    private InventarioProducto inventarioProducto;
    private HabilitadoProducto habilitadoProducto;

    public Producto() {
    }

    public Producto(ProductoId productoId, NombreProducto nombreProducto, DescripcionProducto descripcionProducto, PrecioProducto precioProducto, MarcaProducto marcaProducto, InventarioProducto inventarioProducto, HabilitadoProducto habilitadoProducto) {
        this.productoId = productoId;
        this.nombreProducto = nombreProducto;
        this.descripcionProducto = descripcionProducto;
        this.precioProducto = precioProducto;
        this.marcaProducto = marcaProducto;
        this.inventarioProducto = inventarioProducto;
        this.habilitadoProducto = habilitadoProducto;
    }

    public HashMap<String, Object> data() {
        return new HashMap<>() {{
            put("id", productoId.value());
            put("nombre", nombreProducto.value());
            put("descripcion", descripcionProducto.value());
            put("precio", precioProducto.value());
            put("marca", marcaProducto.value());
            put("inventario", inventarioProducto.value());
        }};
    }

    public static Producto create(ProductoId productoId, NombreProducto nombreProducto, DescripcionProducto descripcionProducto, PrecioProducto precioProducto, MarcaProducto marcaProducto) {
        return new Producto(productoId, nombreProducto, descripcionProducto, precioProducto, marcaProducto, new InventarioProducto(0), new HabilitadoProducto(true));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Producto product = (Producto) o;
        return Objects.equals(productoId, product.productoId) &&
                Objects.equals(nombreProducto, product.nombreProducto) &&
                Objects.equals(descripcionProducto, product.descripcionProducto) &&
                Objects.equals(marcaProducto, product.marcaProducto);
    }

    @Override
    public String toString() {
        return "Producto{" +
                "productoId=" + productoId.value() +
                ", nombreProducto=" + nombreProducto.value() +
                '}';
    }

    public void updateNombreProducto(String nombre) {
        this.nombreProducto = new NombreProducto(nombre);
    }

    public void updateDescripcionProducto(String descripcion) {
        this.descripcionProducto = new DescripcionProducto(descripcion);
    }

    public void updatePrecioProducto(Double precio) {
        this.precioProducto = new PrecioProducto(precio);
    }

    public void updateMarcaProducto(String marca) {
        this.marcaProducto = new MarcaProducto(marca);
    }

    public void deshabilitarProducto() {
        this.habilitadoProducto = new HabilitadoProducto(false);
    }

    public boolean isHabilitado() {
        return this.habilitadoProducto.value();
    }

    public boolean isThereStock(int quantity) {
        return inventarioProducto.value() > quantity;
    }

    public void consume(int quantity) {
        this.inventarioProducto = new InventarioProducto(this.inventarioProducto.value() - quantity);
    }

    public boolean disponibilidad(int cantidad) {
        boolean disponible = false;
        if (this.inventarioProducto.value() > cantidad) {
            disponible = true;
        }
        return disponible;
    }

    public boolean habilitado() {
        return this.habilitadoProducto.value();
    }

    public void loadStock(int quantity) {
        this.inventarioProducto = new InventarioProducto(this.inventarioProducto.value() + quantity);
    }
}
