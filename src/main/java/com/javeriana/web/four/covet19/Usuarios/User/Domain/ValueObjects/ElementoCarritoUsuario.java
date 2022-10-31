package com.javeriana.web.four.covet19.Usuarios.User.Domain.ValueObjects;

import java.util.HashMap;
import java.util.Objects;

public class ElementoCarritoUsuario {
    private long cantidad;
    private String idProducto;
    private String nombreProducto;
    private String descripcionProducto;
    private String marcaProducto;
    private Double precioProducto;

    public ElementoCarritoUsuario(long cantidad, String idProducto, String nombreProducto, String descripcionProducto, String marcaProducto, Double precioProducto) {
        this.cantidad = cantidad;
        this.idProducto = idProducto;
        this.nombreProducto = nombreProducto;
        this.descripcionProducto = descripcionProducto;
        this.marcaProducto = marcaProducto;
        this.precioProducto = precioProducto;
    }

    public static ElementoCarritoUsuario create(long cantidad, String idProducto, String nombreProducto, String descripcionProducto, String marcaProducto, Double precioProducto) {
        return new ElementoCarritoUsuario(cantidad, idProducto, nombreProducto, descripcionProducto, marcaProducto, precioProducto);
    }

    public static ElementoCarritoUsuario createProductId(String idProducto) {
        return new ElementoCarritoUsuario(0, idProducto, null, null, null, null);
    }

    public HashMap<String, Object> data()
    {
        HashMap<String, Object> data = new HashMap<String, Object>(){{
            put("idProducto",idProducto);
            put("descripcionProducto", descripcionProducto);
            put("marcaProducto", marcaProducto);
            put("nombreProducto", nombreProducto);
            put("cantidad", cantidad);
            put("precioProducto", precioProducto);
        }};
        return data;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ElementoCarritoUsuario that = (ElementoCarritoUsuario) o;
        return Objects.equals(idProducto, that.idProducto);
    }
    private ElementoCarritoUsuario(){}

    public String getIdProducto() {
        return this.idProducto;
    }

    public void sumarCantidad(ElementoCarritoUsuario elementoCarritoDetails) {
        Double precio = this.precioProducto / this.cantidad;
        this.cantidad += elementoCarritoDetails.cantidad;
        this.precioProducto = precio * this.cantidad;
    }

    public boolean restarCantidad(ElementoCarritoUsuario elementoCarritoDetails) {
        boolean delete = false;
        Double precio = this.precioProducto / this.cantidad;
        this.cantidad -= elementoCarritoDetails.cantidad;
        this.precioProducto = precio * this.cantidad;
        if(cantidad <= 0) {
            delete = true;
        }
        return delete;
    }
}
