package com.javeriana.web.four.covet19.Usuarios.User.Infrastructure.Controllers.ModificarCantidadElementoCarrito;

public class ModifcarCantidadElementoCarritoRequest {
        private long cantidad;
        private String idProducto;

        public long getCantidad() {
            return cantidad;
        }

        public void setCantidad(long cantidad) {
            this.cantidad = cantidad;
        }

        public String getIdProducto() {
            return idProducto;
        }

        public void setIdProducto(String idProducto) {
            this.idProducto = idProducto;
        }
}
