package com.javeriana.web.four.covet19.Shared.Application;

import com.javeriana.web.four.covet19.Shared.Domain.Bus.Event.DomainEventSubscriber;
import com.javeriana.web.four.covet19.Shared.Domain.Mail.MailIssuedDomainEvent;
import com.javeriana.web.four.covet19.Shared.Domain.Ports.MailSender;
import org.springframework.context.event.EventListener;

import java.io.IOException;

@DomainEventSubscriber({MailIssuedDomainEvent.class})
public class MailIssuedOnEvent {

    MailSender sender;

    public MailIssuedOnEvent(MailSender sender) {
        this.sender = sender;
    }

    @EventListener
    public void on(MailIssuedDomainEvent event) {
        try {
            sender.send(event.getEmail(), event.getSubject(), event.getContent());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
