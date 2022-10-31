package com.javeriana.web.four.covet19.Usuarios.Pedidos.Pedido.Infrastructure.Controllers;


import com.javeriana.web.four.covet19.Usuarios.Pedidos.Pedido.Application.All.PedidoAll;
import com.javeriana.web.four.covet19.Usuarios.Pedidos.Pedido.Application.All.PedidoAllResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping(value = "/pedidos")
public class AllPedidoGetController {
    @Autowired
    private PedidoAll pedidoAll;

    @GetMapping
    public ResponseEntity<List<HashMap>> execute()
    {
        PedidoAllResponse response = new PedidoAllResponse(pedidoAll.execute());
        return ResponseEntity.status(HttpStatus.OK).body(response.response());
    }
}
