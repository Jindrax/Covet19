package com.javeriana.web.four.covet19.Shared.Domain.Aggregate;

import com.javeriana.web.four.covet19.Shared.Domain.Bus.Event.DomainEvent;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class AggregateRoot {

    private List<DomainEvent> domainEvents = new ArrayList<>();

    final public List<DomainEvent> pullDomainEvents() {
        List<DomainEvent> events = domainEvents;
        domainEvents = Collections.emptyList();
        return events;
    }

    final protected void record(DomainEvent event) {
        domainEvents.add(event);
    }

}
