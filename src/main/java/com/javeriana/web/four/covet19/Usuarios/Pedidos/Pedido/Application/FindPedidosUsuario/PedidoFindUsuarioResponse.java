package com.javeriana.web.four.covet19.Usuarios.Pedidos.Pedido.Application.FindPedidosUsuario;

import com.javeriana.web.four.covet19.Usuarios.Pedidos.Pedido.Domain.Pedido;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class PedidoFindUsuarioResponse {
    private List<Pedido> pedidos;
    private final String idUsuario;
    public PedidoFindUsuarioResponse(List<Pedido> pedidos, String idUsuario) {

        this.pedidos = pedidos;
        this.idUsuario = idUsuario;
    }
    public List<HashMap> response()
    {
        this.pedidos = this.pedidos.stream().filter(p -> p.getIdUsiario().equals(this.idUsuario)).collect(Collectors.toList());
        List<HashMap> response = this.pedidos.stream().map(p -> p.data()).collect(Collectors.toList());
        return response;
    }
}
