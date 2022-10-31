package com.javeriana.web.four.covet19.Usuarios.Pedidos.Pedido.Infrastructure.Controllers;

import com.javeriana.web.four.covet19.Usuarios.Pedidos.Pedido.Application.Finalizar.PedidoFinderFinalizar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;


@RestController
@RequestMapping(value = "/pedidos")
public class FinalizarPedidoByIdGetController {
    @Autowired
    private PedidoFinderFinalizar finder;

    @GetMapping(value="/finalizar/{id}")
    public ResponseEntity<HashMap> execute(@PathVariable("id") String id)
    {
        finder.execute(id);
        return ResponseEntity.status(HttpStatus.OK).body(null);
    }
}
