package com.javeriana.web.four.covet19.Productos.Producto.Infrastructure.Controllers;

import com.javeriana.web.four.covet19.Productos.Producto.Application.BucarProducto.BuscarProducto;
import com.javeriana.web.four.covet19.Productos.Producto.Application.BucarProducto.BuscarProductoResponse;
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
@RequestMapping(value = "/productos" )
public class BuscarProductoGetController {

    @Autowired
    private BuscarProducto buscarProducto;

    @GetMapping(value = "/buscar/{nombreProducto}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<HashMap>> execute(@PathVariable("nombreProducto") String nombreBusqueda){
        HttpStatus codigo = HttpStatus.CREATED;
        BuscarProductoResponse response = new BuscarProductoResponse(buscarProducto.execute(nombreBusqueda));
        return ResponseEntity.status(codigo).body(response.response());
    }
}
