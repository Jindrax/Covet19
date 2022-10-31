package com.javeriana.web.four.covet19.Shared.Domain.Bus.Event;


import java.util.List;

public interface EventBus {
    void publish(final List<DomainEvent> events);
}
