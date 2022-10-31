package com.javeriana.web.four.covet19.Shared.Domain.Index.Application.Create;

import com.javeriana.web.four.covet19.Shared.Domain.Admin.PersonCreatedDomainEvent;
import com.javeriana.web.four.covet19.Shared.Domain.Bus.Event.DomainEventSubscriber;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;

@DomainEventSubscriber({PersonCreatedDomainEvent.class})
public class CreateIndexOnPersonCreated {

    private final CreateIndex createIndex;

    public CreateIndexOnPersonCreated(CreateIndex createIndex) {
        this.createIndex = createIndex;
    }

    @Async
    @EventListener
    public void on(PersonCreatedDomainEvent event) {
        this.createIndex.execute(event.getEmail(), event.aggregateId(), event.getRol());
    }

}
