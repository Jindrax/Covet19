package com.javeriana.web.four.covet19.Shared.Infrastructure.Bus.Event.RabbitMQ.Serializable;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.javeriana.web.four.covet19.Shared.Domain.Bus.Event.DomainEvent;
import com.javeriana.web.four.covet19.Shared.Infrastructure.Bus.Event.RabbitMQ.DomainEventsInformation;

import java.io.IOException;
import java.io.Serializable;
import java.lang.reflect.Method;
import java.util.HashMap;

public final class DomainEventJsonDeserializer {

    private final DomainEventsInformation information;

    public DomainEventJsonDeserializer(DomainEventsInformation information) {
        this.information = information;
    }

    public DomainEvent deserialize(String body) throws Exception {
        HashMap<String, Serializable> eventData = this.jsonDecode(body);
        HashMap<String, Serializable> data = (HashMap<String, Serializable>) eventData.get("data");
        HashMap<String, Serializable> attributes = (HashMap<String, Serializable>) data.get("attributes");
        Class<?extends DomainEvent> domainEventClass = information.getDomainEvent((String) data.get("type"));

        DomainEvent nullInstance = domainEventClass.getConstructor().newInstance();
        Method fromPrimitivesMethod = domainEventClass.getMethod("fromPrimitive",
                String.class, HashMap.class, String.class, String.class);

        Object domainEvent = fromPrimitivesMethod.invoke(nullInstance,
                attributes.get("id"),
                attributes,
                data.get("id"),
                data.get("occurred_on"));

        return (DomainEvent) domainEvent;
    }

    public HashMap<String, Serializable> jsonDecode(String body) {
        try {
            return new ObjectMapper().readValue(body, HashMap.class);
        }
        catch (IOException e) {
            return null;
        }
    }

}
