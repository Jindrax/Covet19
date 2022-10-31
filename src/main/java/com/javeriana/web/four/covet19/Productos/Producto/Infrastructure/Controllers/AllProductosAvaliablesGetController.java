package com.javeriana.web.four.covet19.Productos.Producto.Infrastructure.Controllers;

import com.javeriana.web.four.covet19.Productos.Producto.Application.AllAvaliable.AllAvaliableProductos;
import com.javeriana.web.four.covet19.Productos.Producto.Domain.Producto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/productos")
public class AllProductosAvaliablesGetController {

    @Autowired
    private AllAvaliableProductos allAvaliableProductos;

    @GetMapping(value = "/catalogo", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<HashMap<String, Object>>> execute(){
        try{
            List<HashMap<String, Object>> productos = allAvaliableProductos.execute().stream().map(Producto::data).collect(Collectors.toList());
            return ResponseEntity.ok(productos);
        }catch (Exception e){
            System.out.println(e);
            return ResponseEntity.status(400).body(null);
        }
    }
}
