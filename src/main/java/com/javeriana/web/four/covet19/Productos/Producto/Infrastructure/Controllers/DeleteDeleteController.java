package com.javeriana.web.four.covet19.Productos.Producto.Infrastructure.Controllers;

import com.javeriana.web.four.covet19.Productos.Producto.Application.Delete.DeleteProducto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/producto")
public class DeleteDeleteController {

    @Autowired
    private DeleteProducto deleteProducto;

    @DeleteMapping(value = "/{id}")
    public ResponseEntity execute(@PathVariable String id) {
        try {
            deleteProducto.execute(id);
        } catch (Exception e) {
            System.out.println(e);
            return ResponseEntity.status(400).body(e.getMessage());
        }
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(null);
    }
}
