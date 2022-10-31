package com.javeriana.web.four.covet19.Veterinarios.Cita.Application.VerCita;

import com.javeriana.web.four.covet19.Veterinarios.Cita.Domain.Cita;
import com.javeriana.web.four.covet19.Veterinarios.Cita.Domain.Exceptions.CitaNoExiste;
import com.javeriana.web.four.covet19.Veterinarios.Cita.Domain.Ports.CitaRepository;

import java.util.Optional;

public class CitaVerCita {

    private final CitaRepository repository;

    public CitaVerCita(CitaRepository repository) {
        this.repository = repository;
    }

    public Cita execute(String idCita)
    {
        Optional<Cita> cita = repository.find(idCita);
        if (cita.isEmpty())
        {
            throw new CitaNoExiste(idCita);
        }
        Cita finalCita = cita.get();

        return finalCita;
    }
}
