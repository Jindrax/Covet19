package com.javeriana.web.four.covet19.Usuarios.Pedidos.Pedido.Application.FindPedidosUsuario;

import com.javeriana.web.four.covet19.Usuarios.Pedidos.Pedido.Domain.Pedido;
import com.javeriana.web.four.covet19.Usuarios.Pedidos.Pedido.Domain.Ports.PedidoRepository;

import java.util.List;
import java.util.Optional;

public class PedidoFindUsuarioAll {
    private final PedidoRepository repository;

    public PedidoFindUsuarioAll(PedidoRepository repository) {
        this.repository = repository;
    }

    public List<Pedido> execute()
    {
        Optional<List<Pedido>> pedidos = repository.all();
        if (pedidos.isEmpty())
        {
            throw new RuntimeException("Error");
        }
        return pedidos.get();
    }
}
