package com.javeriana.web.four.covet19.Productos.Producto.Infrastructure.Controllers;

import java.util.Optional;

public class UpdateProductoRequest {
    private Optional<String> id;
    private Optional<String> nombre;
    private Optional<String> descripcion;
    private Optional<Double> precio;
    private Optional<String> marca;

    public UpdateProductoRequest() {
        this.id = Optional.empty();
        this.nombre = Optional.empty();
        this.descripcion = Optional.empty();
        this.precio = Optional.empty();
        this.marca = Optional.empty();
    }

    public Optional<String> getId() {
        return id;
    }

    public void setId(String id) {
        this.id = Optional.ofNullable(id);
    }

    public Optional<String> getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = Optional.ofNullable(nombre);
    }

    public Optional<String> getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = Optional.ofNullable(descripcion);
    }

    public Optional<Double> getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = Optional.ofNullable(precio);
    }

    public Optional<String> getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = Optional.ofNullable(marca);
    }

    @Override
    public String toString() {
        return "Request{" +
                "id=" + id.orElse("no_id") +
                ", nombre=" + nombre.orElse("no_name") +
                ", descripcion=" + descripcion.orElse("no_descripcion") +
                ", precio=" + precio.orElse(0d) +
                ", marca=" + marca.orElse("no_marca") +
                '}';
    }
}
