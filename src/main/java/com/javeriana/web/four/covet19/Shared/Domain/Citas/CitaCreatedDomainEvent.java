package com.javeriana.web.four.covet19.Shared.Domain.Citas;

import com.javeriana.web.four.covet19.Shared.Domain.Bus.Event.DomainEvent;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;

public class CitaCreatedDomainEvent extends DomainEvent {

    private String mascotaId;
    private String veterinarioId;
    private String usuarioId;
    private Date fecha;

    public CitaCreatedDomainEvent() {
    }

    public CitaCreatedDomainEvent(String aggregateId, String mascotaId, String veterinarioId, String usuarioId, Date fecha) {
        super(aggregateId);
        this.mascotaId = mascotaId;
        this.veterinarioId = veterinarioId;
        this.usuarioId = usuarioId;
        this.fecha = fecha;
    }

    public CitaCreatedDomainEvent(String aggregateId, String eventId, String occurredOn, String mascotaId, String veterinarioId, String usuarioId, Date fecha) {
        super(aggregateId, eventId, occurredOn);
        this.mascotaId = mascotaId;
        this.veterinarioId = veterinarioId;
        this.usuarioId = usuarioId;
        this.fecha = fecha;
    }

    public String getMascotaId() {
        return mascotaId;
    }

    public String getVeterinarioId() {
        return veterinarioId;
    }

    public String getUsuarioId() {
        return usuarioId;
    }

    public Date getFecha() {
        return fecha;
    }

    @Override
    public String eventName() {
        return "cita.created";
    }

    @Override
    public HashMap<String, Serializable> toPrimitive() {
        return new HashMap<String, Serializable>() {{
            put("mascotaId", mascotaId);
            put("veteriarioId", veterinarioId);
            put("usuarioId", usuarioId);
            put("fecha", fecha);
        }};
    }

    @Override
    public DomainEvent fromPrimitive(String aggregateId, HashMap<String, Serializable> body, String eventId, String occurredOn) {
        return new CitaCreatedDomainEvent(aggregateId, eventId, occurredOn, (String) body.get("mascotaId"), (String) body.get("veteriarioId"), (String) body.get("usuarioId"), (Date) body.get("fecha"));
    }
}
