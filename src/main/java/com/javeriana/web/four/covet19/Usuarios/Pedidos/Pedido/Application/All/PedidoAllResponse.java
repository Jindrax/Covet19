package com.javeriana.web.four.covet19.Usuarios.Pedidos.Pedido.Application.All;

import com.javeriana.web.four.covet19.Usuarios.Pedidos.Pedido.Domain.Pedido;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class PedidoAllResponse {
    private final List<Pedido> pedidos;

    public PedidoAllResponse(List<Pedido> pedidos) {
        this.pedidos = pedidos;
    }
    public List<HashMap> response()
    {
        List<HashMap> response = pedidos.stream().map(p -> p.data()).collect(Collectors.toList());
        return response;
    }
}
