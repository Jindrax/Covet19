package com.javeriana.web.four.covet19.Shared.Infrastructure.Bus.Event.RabbitMQ;

import com.javeriana.web.four.covet19.Shared.Domain.Bus.Event.DomainEvent;
import com.javeriana.web.four.covet19.Shared.Infrastructure.Bus.Event.RabbitMQ.Serializable.DomainEventJsonSerializable;
import org.springframework.amqp.AmqpException;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessagePropertiesBuilder;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;

public final class RabbitMqPublisher {

    @Autowired
    private final RabbitTemplate rabbitTemplate;

    public RabbitMqPublisher(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void publish(DomainEvent domainEvent, String exchangeName) throws AmqpException {
        String serializedDomainEvent = DomainEventJsonSerializable.serialize(domainEvent);

        Message message = new Message(
                serializedDomainEvent.getBytes(),
                MessagePropertiesBuilder.newInstance()
                        .setContentEncoding("utf-8")
                        .setContentType("application/json").build()
        );

        rabbitTemplate.send(exchangeName, domainEvent.eventName(), message);
    }
}
