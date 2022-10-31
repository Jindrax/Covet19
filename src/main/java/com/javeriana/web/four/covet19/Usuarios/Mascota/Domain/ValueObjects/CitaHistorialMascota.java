package com.javeriana.web.four.covet19.Usuarios.Mascota.Domain.ValueObjects;

import java.util.HashMap;
import java.util.Objects;

public class CitaHistorialMascota {
    private String idHistorial;
    private String diagnostico;
    private String fecha;
    private String idVeterinario;

    public CitaHistorialMascota(String idHistorial, String diagnostico, String fecha, String idPersona) {
        this.idHistorial = idHistorial;
        this.diagnostico = diagnostico;
        this.fecha = fecha;
        this.idVeterinario = idPersona;
    }
    public CitaHistorialMascota(){}

    public static CitaHistorialMascota createCitaId(String idCita) {
        return new CitaHistorialMascota(idCita, null, null, null);
    }
    public HashMap<String, Object> data() {
        HashMap<String, Object> data = new HashMap<String, Object>() {{
            put("id", idHistorial);
            put("diagnostico", diagnostico);
            put("fecha", fecha);
            put("idVeterinario", idVeterinario);
        }};
        return data;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CitaHistorialMascota that = (CitaHistorialMascota) o;
        return Objects.equals(idHistorial, that.idHistorial) && Objects.equals(diagnostico, that.diagnostico) && Objects.equals(fecha, that.fecha) && Objects.equals(idVeterinario, that.idVeterinario);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idHistorial, diagnostico, fecha, idVeterinario);
    }

    public String getIdHistorial() {
        return this.idHistorial;
    }

    public boolean equalsIdHistorial(CitaHistorialMascota citaHistorialMascota) {
        return this.idHistorial.equals(citaHistorialMascota.getIdHistorial());
    }

    public boolean equalsIdCita(String idCita) {
        return this.idHistorial.equals(idCita);
    }
    public boolean equalsIdCita( CitaHistorialMascota citaDetails) {
        return this.idHistorial.equals(citaDetails.getIdHistorial());
    }

    public void updateDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }
    public void updateFecha(String fecha) {
        this.fecha = fecha;
    }
}
