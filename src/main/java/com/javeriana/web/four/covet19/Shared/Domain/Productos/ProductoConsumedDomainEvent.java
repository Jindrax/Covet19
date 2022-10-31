package com.javeriana.web.four.covet19.Shared.Domain.Productos;

import com.javeriana.web.four.covet19.Shared.Domain.Bus.Event.DomainEvent;

import java.io.Serializable;
import java.util.HashMap;

public class ProductoConsumedDomainEvent extends DomainEvent {

    private final long quantity;

    public ProductoConsumedDomainEvent() {
        super(null);
        this.quantity = 0L;
    }

    public ProductoConsumedDomainEvent(String aggregateId, long quantity) {
        super(aggregateId);
        this.quantity = quantity;
    }

    public ProductoConsumedDomainEvent(String aggregateId, String eventId, String occurredOn, long quantity) {
        super(aggregateId, eventId, occurredOn);
        this.quantity = quantity;
    }

    public long getQuantity() {
        return quantity;
    }

    @Override
    public String eventName() {
        return "producto.consumed";
    }

    @Override
    public HashMap<String, Serializable> toPrimitive() {
        return new HashMap<String, Serializable>() {{
            put("quantity", quantity);
        }};
    }

    @Override
    public DomainEvent fromPrimitive(String aggregateId, HashMap<String, Serializable> body, String eventId, String occurredOn) {
        return new ProductoConsumedDomainEvent(aggregateId, eventId, occurredOn, (long) body.get("quantity"));
    }
}
