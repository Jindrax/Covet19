package com.javeriana.web.four.covet19.Shared.Domain.Citas;

import com.javeriana.web.four.covet19.Shared.Domain.Bus.Event.DomainEvent;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;

public class CitaAgregarDiagnosticoDomainEvent extends DomainEvent {

    private String mascotaId;
    private String veterinarioId;
    private String diagnostico;

    public CitaAgregarDiagnosticoDomainEvent() {
    }

    public CitaAgregarDiagnosticoDomainEvent(String aggregateId, String mascotaId, String veterinarioId, String diagnostico) {
        super(aggregateId);
        this.mascotaId = mascotaId;
        this.veterinarioId = veterinarioId;
        this.diagnostico = diagnostico;
    }

    public CitaAgregarDiagnosticoDomainEvent(String aggregateId, String eventId, String occurredOn, String mascotaId, String veterinarioId, String diagnostico) {
        super(aggregateId, eventId, occurredOn);
        this.mascotaId = mascotaId;
        this.veterinarioId = veterinarioId;
        this.diagnostico = diagnostico;
    }

    public String getMascotaId() {
        return mascotaId;
    }

    public String getVeterinarioId() {
        return veterinarioId;
    }

    public String getDiagnostico() {
        return diagnostico;
    }

    @Override
    public String eventName() {
        return "cita.agregarDiagnostico";
    }

    @Override
    public HashMap<String, Serializable> toPrimitive() {
        return new HashMap<String, Serializable>() {{
            put("mascotaId", mascotaId);
            put("veteriarioId", veterinarioId);
            put("diagnostico", diagnostico);
        }};
    }

    @Override
    public DomainEvent fromPrimitive(String aggregateId, HashMap<String, Serializable> body, String eventId, String occurredOn) {
        return new CitaAgregarDiagnosticoDomainEvent(aggregateId, eventId, occurredOn, (String) body.get("mascotaId"), (String) body.get("veteriarioId"), (String) body.get("diagnostico"));
    }
}
