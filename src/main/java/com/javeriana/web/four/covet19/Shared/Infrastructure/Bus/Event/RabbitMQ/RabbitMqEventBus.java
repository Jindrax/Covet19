package com.javeriana.web.four.covet19.Shared.Infrastructure.Bus.Event.RabbitMQ;


import com.javeriana.web.four.covet19.Shared.Domain.Bus.Event.DomainEvent;
import com.javeriana.web.four.covet19.Shared.Domain.Bus.Event.EventBus;
import org.springframework.amqp.AmqpException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;

import java.util.List;


public class RabbitMqEventBus implements EventBus {

    private final RabbitMqPublisher publisher;
    private final String exchangeName;
    @Autowired
    private final Environment env;

    public RabbitMqEventBus(RabbitMqPublisher publisher, Environment env) {
        this.publisher = publisher;
        this.env = env;
        this.exchangeName = env.getProperty("rabbit.exchange");
    }

    @Override
    public void publish(List<DomainEvent> events) {
        events.forEach(this::publish);
    }

    private void publish(DomainEvent domainEvent) {
        try {
            this.publisher.publish(domainEvent, this.exchangeName);
        }
        catch (AmqpException error) {
            System.err.println("Error Publicando: " + error);
            //TODO: Implementar un Failover de Rabbit
        }
    }
}
