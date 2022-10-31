package com.javeriana.web.four.covet19.Veterinarios.Veterinario.Domain.ValueObjects;

import java.util.HashMap;
import java.util.Objects;

public class CitaDetails {
    private String idCita;
    private String diagnostico;
    private String fecha;
    private String idMascota;

    public CitaDetails(String idCita, String diagnostico, String fecha, String idMascota) {
        this.idCita = idCita;
        this.diagnostico = diagnostico;
        this.fecha = fecha;
        this.idMascota = idMascota;
    }
    public static CitaDetails createCitaId(String idCita) {
        return new CitaDetails(idCita, null, null, null);
    }
    public HashMap<String, Object> data() {
        HashMap<String, Object> data = new HashMap<String, Object>() {{
            put("id", idCita);
            put("diagnostico", diagnostico);
            put("fecha", fecha);
            put("idMascota", idMascota);
        }};
        return data;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CitaDetails that = (CitaDetails) o;
        return Objects.equals(idCita, that.idCita) && Objects.equals(diagnostico, that.diagnostico) && Objects.equals(fecha, that.fecha) && Objects.equals(idMascota, that.idMascota);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idCita, diagnostico, fecha, idMascota);
    }

    public String getIdCita() {
        return this.idCita;
    }

    public boolean equalsIdCita(CitaDetails productColorDetails) {
        return this.idCita.equals(productColorDetails.getIdCita());
    }

    public boolean equalsIdCita(String idCita) {
        return this.idCita.equals(idCita);
    }

    private CitaDetails () {}

    public void updateDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }
    public void updateFecha(String fecha) {
        this.fecha = fecha;
    }
}
