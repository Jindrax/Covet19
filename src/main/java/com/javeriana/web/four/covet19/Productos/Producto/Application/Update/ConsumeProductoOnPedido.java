package com.javeriana.web.four.covet19.Productos.Producto.Application.Update;

import com.javeriana.web.four.covet19.Productos.Producto.Domain.Producto;
import com.javeriana.web.four.covet19.Productos.Producto.Infrastructure.Hibernate.HibernateProductoRepository;
import com.javeriana.web.four.covet19.Shared.Domain.Bus.Event.DomainEventSubscriber;
import com.javeriana.web.four.covet19.Shared.Domain.Productos.ProductoConsumedDomainEvent;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;

import java.util.Optional;

@Async
@DomainEventSubscriber({ProductoConsumedDomainEvent.class})
public class ConsumeProductoOnPedido {

    private final HibernateProductoRepository repository;

    public ConsumeProductoOnPedido(HibernateProductoRepository repository) {
        this.repository = repository;
    }

    @EventListener
    public void on(ProductoConsumedDomainEvent event) {
        Optional<Producto> producto = repository.find(event.aggregateId());
        producto.ifPresent(value -> {
            value.consume((int) event.getQuantity());
            repository.update(producto.get());
        });
    }
}
