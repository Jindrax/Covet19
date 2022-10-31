package com.javeriana.web.four.covet19.Shared.Domain.Mail;

import com.javeriana.web.four.covet19.Shared.Domain.Bus.Event.DomainEvent;

import java.io.Serializable;
import java.util.HashMap;

public class MailIssuedDomainEvent extends DomainEvent {

    private String email;
    private String subject;
    private String content;

    public MailIssuedDomainEvent() {
    }

    public MailIssuedDomainEvent(String aggregateId, String email, String subject, String content) {
        super(aggregateId);
        this.email = email;
        this.subject = subject;
        this.content = content;
    }

    public MailIssuedDomainEvent(String aggregateId, String eventId, String occurredOn, String email, String subject, String content) {
        super(aggregateId, eventId, occurredOn);
        this.email = email;
        this.subject = subject;
        this.content = content;
    }

    public String getEmail() {
        return email;
    }

    public String getSubject() {
        return subject;
    }

    public String getContent() {
        return content;
    }

    @Override
    public String eventName() {
        return "mail.issued";
    }

    @Override
    public HashMap<String, Serializable> toPrimitive() {
        return new HashMap<String, Serializable>() {{
            put("email", email);
            put("subject", subject);
            put("content", content);
        }};
    }

    @Override
    public DomainEvent fromPrimitive(String aggregateId, HashMap<String, Serializable> body, String eventId, String occurredOn) {
        return new MailIssuedDomainEvent(aggregateId,
                eventId,
                occurredOn,
                (String) body.get("email"),
                (String) body.get("subject"),
                (String) body.get("content"));
    }
}
