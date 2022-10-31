package com.javeriana.web.four.covet19.Usuarios.Pedidos.Pedido.Application.Create;

import com.javeriana.web.four.covet19.Productos.Producto.Application.CanConsume.CanConsumeProducto;
import com.javeriana.web.four.covet19.Shared.Domain.Bus.Event.EventBus;
import com.javeriana.web.four.covet19.Usuarios.Pedidos.Pedido.Domain.Exceptions.NotEnoughStock;
import com.javeriana.web.four.covet19.Usuarios.Pedidos.Pedido.Domain.Pedido;
import com.javeriana.web.four.covet19.Usuarios.Pedidos.Pedido.Domain.ValueObjects.CompraPedidoDetail;
import com.javeriana.web.four.covet19.Usuarios.Pedidos.Pedido.Infrastructure.Hibernate.HibernatePedidoRepository;
import com.javeriana.web.four.covet19.Usuarios.User.Domain.User;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

public class CreatePedido {

    HibernatePedidoRepository repository;
    CanConsumeProducto consumer;
    EventBus eventBus;

    public CreatePedido(HibernatePedidoRepository repository, CanConsumeProducto consumer, EventBus eventBus) {
        this.repository = repository;
        this.consumer = consumer;
        this.eventBus = eventBus;
    }

    public void execute(User user){
        Optional<List<HashMap<String, Object>>> carrito = user.getUserCarrito();
        Pedido pedido = Pedido.create(user.getUserId().value());
        carrito.ifPresent(hashMaps -> hashMaps.stream().map(producto -> new CompraPedidoDetail((String) producto.get("idProducto"),
                (String) producto.get("nombreProducto"),
                (String) producto.get("descripcionProducto"),
                (double) producto.get("precioProducto"),
                (String) producto.get("marcaProducto"),
                (long) producto.get("cantidad"))).forEach(compraPedidoDetail -> {
                    if(consumer.execute(compraPedidoDetail.getId(), (int) compraPedidoDetail.getCantidad())){
                        pedido.consumirProducto(compraPedidoDetail);
                    }else{
                        throw new NotEnoughStock("No hay suficiente cantidad de " + compraPedidoDetail.getNombre());
                    }
        }));
        repository.save(pedido);
        pedido.sendTo(user.getUserMail().value());
        eventBus.publish(pedido.pullDomainEvents());
    }
}
