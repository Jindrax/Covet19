package com.javeriana.web.four.covet19.Usuarios.Pedidos.Pedido.Domain.Ports;

import com.javeriana.web.four.covet19.Usuarios.Pedidos.Pedido.Domain.Pedido;

import java.util.List;
import java.util.Optional;

public interface PedidoRepository {
    void update(Pedido pedido);
    Optional<Pedido> find (String idPedido);
    void save(Pedido pedido);
    Optional<List<Pedido>> all();
}
