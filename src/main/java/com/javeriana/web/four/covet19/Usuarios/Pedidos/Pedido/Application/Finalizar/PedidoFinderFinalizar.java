package com.javeriana.web.four.covet19.Usuarios.Pedidos.Pedido.Application.Finalizar;

import com.javeriana.web.four.covet19.Usuarios.Pedidos.Pedido.Domain.Exceptions.PedidoEnviado;
import com.javeriana.web.four.covet19.Usuarios.Pedidos.Pedido.Domain.Exceptions.PedidoFinalizado;
import com.javeriana.web.four.covet19.Usuarios.Pedidos.Pedido.Domain.Exceptions.PedidoNotExist;
import com.javeriana.web.four.covet19.Usuarios.Pedidos.Pedido.Domain.Pedido;
import com.javeriana.web.four.covet19.Usuarios.Pedidos.Pedido.Domain.Ports.PedidoRepository;

import java.util.Optional;

public class PedidoFinderFinalizar {

    private final PedidoRepository repository;

    public PedidoFinderFinalizar(PedidoRepository repository) {
        this.repository = repository;
    }

    public void execute(String id) {
        Optional<Pedido> pedido = repository.find(id);
        if (pedido.isEmpty()) {
            throw new PedidoNotExist("The pedido " + id + " not exists");
        }
        Pedido pedidoUpdate = pedido.get();
        if(!pedidoUpdate.getfinalizadoPedido() && pedidoUpdate.getEnviadoPedido()){
            pedidoUpdate.finalizarPedido();
            repository.update(pedidoUpdate);
        }else if(pedidoUpdate.getfinalizadoPedido() ){
            throw new PedidoFinalizado("The pedido " + id + " is already finished");
        }else {
            throw new PedidoEnviado("The pedido " + id + " has not been sent ");
        }

    }
}
