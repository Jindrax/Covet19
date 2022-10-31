package com.javeriana.web.four.covet19.Usuarios.User.Infrastructure.Controllers.ModificarCantidadElementoCarrito;

import com.javeriana.web.four.covet19.Usuarios.User.Application.ModificarCantidadElementoCarrito.UserModificarCantidadElementoCarrito;
import com.javeriana.web.four.covet19.Usuarios.User.Domain.ValueObjects.ElementoCarritoUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping(value = "/users/{idUser}/carrito/update/{idProducto}")
public class AddCantidadElementoCarritoPostController {

    @Autowired
    private UserModificarCantidadElementoCarrito modificarCantidadElementoCarrito;

    @PostMapping(value = "/add", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<HashMap<String, Object>>> execute(@PathVariable("idUser") String idUser, @PathVariable("idProducto") String idProducto, @RequestBody ModifcarCantidadElementoCarritoRequest request)
    {
        modificarCantidadElementoCarrito.execute(idUser, ElementoCarritoUsuario.create(
                request.getCantidad(),
                request.getIdProducto(),
                null,
                null,
                null,
                null
        ),true);
        return ResponseEntity.status(HttpStatus.OK).body(null);
    }

}
