package com.javeriana.web.four.covet19.Usuarios.Pedidos.Pedido.Application.Enviar;

import com.javeriana.web.four.covet19.Usuarios.Pedidos.Pedido.Domain.Exceptions.PedidoEnviado;
import com.javeriana.web.four.covet19.Usuarios.Pedidos.Pedido.Domain.Exceptions.PedidoNotExist;
import com.javeriana.web.four.covet19.Usuarios.Pedidos.Pedido.Domain.Pedido;
import com.javeriana.web.four.covet19.Usuarios.Pedidos.Pedido.Domain.Ports.PedidoRepository;

import java.util.Optional;

public class PedidoFinderEnviar {

    private final PedidoRepository repository;

    public PedidoFinderEnviar(PedidoRepository repository) {
        this.repository = repository;
    }

    public void execute(String id) {
        Optional<Pedido> pedido = repository.find(id);
        if (pedido.isEmpty()) {
            throw new PedidoNotExist("The pedido " + id + " not exists");
        }
        Pedido pedidoUpdate = pedido.get();
        if(!pedidoUpdate.getEnviadoPedido()){
            pedidoUpdate.enviarPedido();
            repository.update(pedidoUpdate);
        }else{
            throw new PedidoEnviado("The pedido " + id + " is already sent");
        }

    }
}
