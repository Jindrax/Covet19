package com.javeriana.web.four.covet19.Veterinarios.Cita.Application.All;

import com.javeriana.web.four.covet19.Veterinarios.Cita.Domain.Cita;
import com.javeriana.web.four.covet19.Veterinarios.Cita.Domain.Ports.CitaRepository;

import java.util.List;
import java.util.Optional;

public class CitaAll {
    private final CitaRepository repository;

    public CitaAll(CitaRepository repository) {
        this.repository = repository;
    }

    public List<Cita> execute()
    {
        Optional<List<Cita>> citas = repository.all();
        if (citas.isEmpty())
        {
            throw new RuntimeException("Error");
        }
        return citas.get();
    }
}
