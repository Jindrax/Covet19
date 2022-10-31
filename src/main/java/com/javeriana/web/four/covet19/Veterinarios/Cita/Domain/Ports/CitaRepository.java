package com.javeriana.web.four.covet19.Veterinarios.Cita.Domain.Ports;

import com.javeriana.web.four.covet19.Veterinarios.Cita.Domain.Cita;

import java.util.List;
import java.util.Optional;

public interface CitaRepository {
    void update(Cita cita);
    Optional<Cita> find (String idCita);
    void save(Cita cita);
    Optional<List<Cita>> all();
    void delete(Cita cita);
}
