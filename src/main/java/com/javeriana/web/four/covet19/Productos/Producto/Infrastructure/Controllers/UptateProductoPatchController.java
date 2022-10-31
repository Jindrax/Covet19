package com.javeriana.web.four.covet19.Productos.Producto.Infrastructure.Controllers;

import com.javeriana.web.four.covet19.Productos.Producto.Application.Update.UpdateProducto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/producto")
public class UptateProductoPatchController {

    @Autowired
    private UpdateProducto updateProducto;

    @PatchMapping(value = "")
    public ResponseEntity execute(@RequestBody UpdateProductoRequest request) {
        try {
            updateProducto.execute(request);
        } catch (Exception e) {
            System.out.println(e);
            return ResponseEntity.status(400).body(e.getMessage());
        }
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(null);
    }
}
