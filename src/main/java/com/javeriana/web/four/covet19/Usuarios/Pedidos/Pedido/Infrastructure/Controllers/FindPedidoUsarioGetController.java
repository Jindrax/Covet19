package com.javeriana.web.four.covet19.Usuarios.Pedidos.Pedido.Infrastructure.Controllers;

import com.javeriana.web.four.covet19.Usuarios.Pedidos.Pedido.Application.FindPedidosUsuario.PedidoFindUsuarioAll;
import com.javeriana.web.four.covet19.Usuarios.Pedidos.Pedido.Application.FindPedidosUsuario.PedidoFindUsuarioResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping(value = "/pedidos")
public class FindPedidoUsarioGetController {

    @Autowired
    private PedidoFindUsuarioAll finder;

    @GetMapping(value="/usuarios/{id}")
    public ResponseEntity<List<HashMap>> execute(@PathVariable("id") String id)
    {
        PedidoFindUsuarioResponse response = new PedidoFindUsuarioResponse(finder.execute(), id);
        return ResponseEntity.status(HttpStatus.OK).body(response.response());
    }
}
