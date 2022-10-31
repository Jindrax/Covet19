package com.javeriana.web.four.covet19.Usuarios.Pedidos.Pedido.Domain.ValueObjects;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Objects;

public class CompraPedidoDetail implements Serializable {
    private String id;
    private String nombre;
    private String descripcion;
    private double precio;
    private String marca;
    private long cantidad;

    public CompraPedidoDetail(String id, String nombre, String descripcion, double precio, String marca, long cantidad) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.marca = marca;
        this.cantidad = cantidad;
    }

    public HashMap<String, Object> data() {
        HashMap<String, Object> data = new HashMap<String, Object>() {{
            put("id", id);
            put("nombre", nombre);
            put("descripcion", descripcion);
            put("precio", precio);
            put("marca", marca);
            put("cantidad", cantidad);
        }};
        return data;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CompraPedidoDetail that = (CompraPedidoDetail) o;
        return cantidad == that.cantidad && Objects.equals(id, that.id) && Objects.equals(nombre, that.nombre) && Objects.equals(descripcion, that.descripcion) && Objects.equals(precio, that.precio) && Objects.equals(marca, that.marca);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nombre, descripcion, precio, marca, cantidad);
    }

    public String getId() {
        return this.id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public double getPrecio() {
        return precio;
    }

    public String getMarca() {
        return marca;
    }

    public long getCantidad() {
        return cantidad;
    }

    private CompraPedidoDetail () {}

}
