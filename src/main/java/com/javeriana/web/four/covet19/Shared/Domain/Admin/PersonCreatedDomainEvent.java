package com.javeriana.web.four.covet19.Shared.Domain.Admin;

import com.javeriana.web.four.covet19.Shared.Domain.Bus.Event.DomainEvent;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Objects;

public class PersonCreatedDomainEvent extends DomainEvent {

    private final String email;
    private final String rol;

    public PersonCreatedDomainEvent() {
        super(null);
        this.email = "";
        this.rol = "";
    }

    public PersonCreatedDomainEvent(String aggregateId, String email, String rol) {
        super(aggregateId);
        this.email = email;
        this.rol = rol;
    }

    public PersonCreatedDomainEvent(String aggregateId, String eventId, String occurredOn, String email, String rol) {
        super(aggregateId, eventId, occurredOn);
        this.email = email;
        this.rol = rol;
    }

    public String getEmail() {
        return email;
    }

    public String getRol() {
        return rol;
    }

    @Override
    public String eventName() {
        return "person.created";
    }

    @Override
    public HashMap<String, Serializable> toPrimitive() {
        return new HashMap<String, Serializable>(){{
            put("email", email);
            put("rol", rol);
        }};
    }

    @Override
    public DomainEvent fromPrimitive(String aggregateId, HashMap<String, Serializable> body, String eventId, String occurredOn) {
        return new PersonCreatedDomainEvent(aggregateId, eventId, occurredOn, (String) body.get("email"), (String) body.get("rol"));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PersonCreatedDomainEvent that = (PersonCreatedDomainEvent) o;
        return Objects.equals(email, that.email) && Objects.equals(rol, that.rol);
    }

    @Override
    public int hashCode() {
        return Objects.hash(email, rol);
    }
}
