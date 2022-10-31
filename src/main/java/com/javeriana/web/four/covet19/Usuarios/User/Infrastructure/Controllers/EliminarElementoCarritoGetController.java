package com.javeriana.web.four.covet19.Usuarios.User.Infrastructure.Controllers;

import com.javeriana.web.four.covet19.Usuarios.User.Application.EliminarElementoCarrito.UserEliminarElementoCarrito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping(value = "/users/{idUser}/carrito/")
public class EliminarElementoCarritoGetController {

    @Autowired
    private UserEliminarElementoCarrito eliminarElementoCarrito;

    @GetMapping(value = "/remove/{idProducto}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<HashMap<String, Object>>> execute(@PathVariable("idUser") String idUser, @PathVariable("idProducto") String idProducto)
    {
        eliminarElementoCarrito.execute(idUser, idProducto);
        return ResponseEntity.status(HttpStatus.OK).body(null);
    }

}
