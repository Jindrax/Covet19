package com.javeriana.web.four.covet19.Usuarios.Pedidos.Pedido.Application.All;

import com.javeriana.web.four.covet19.Usuarios.Pedidos.Pedido.Domain.Pedido;
import com.javeriana.web.four.covet19.Usuarios.Pedidos.Pedido.Domain.Ports.PedidoRepository;

import java.util.List;
import java.util.Optional;

public class PedidoAll {
    private final PedidoRepository repository;

    public PedidoAll(PedidoRepository repository) {
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
