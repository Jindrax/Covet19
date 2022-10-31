
package com.javeriana.web.four.covet19.Usuarios.User.Infrastructure.Controllers;

import com.javeriana.web.four.covet19.Usuarios.User.Application.AgregarElementoCarrito.AgregarElementoCarrito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/users")
public class AgregarElementoCarritoPostController {

    @Autowired
    private AgregarElementoCarrito agregarElementoCarrito;

    @PostMapping (value = "/agregarACarrito", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity execute (@RequestBody Request request){
        HttpStatus codigo = HttpStatus.CREATED;
        agregarElementoCarrito.execute(request.getIdUsuario(), request.getIdProducto(), request.getCantidad() );
        return ResponseEntity.status(codigo).body(null);
    }
    static  class Request{
        private String idUsuario;
        private String idProducto;
        private long cantidad;

        public String getIdUsuario() {
            return idUsuario;
        }

        public void setIdUsuario(String idUsuario) {
            this.idUsuario = idUsuario;
        }

        public String getIdProducto() {
            return idProducto;
        }

        public void setIdProducto(String idProducto) {
            this.idProducto = idProducto;
        }

        public long getCantidad() {
            return cantidad;
        }

        public void setCantidad(long cantidad) {
            this.cantidad = cantidad;
        }
    }

}
