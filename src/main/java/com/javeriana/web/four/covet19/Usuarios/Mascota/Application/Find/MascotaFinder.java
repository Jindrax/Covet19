package com.javeriana.web.four.covet19.Usuarios.Mascota.Application.Find;

import com.javeriana.web.four.covet19.Usuarios.Mascota.Domain.Mascota;
import com.javeriana.web.four.covet19.Usuarios.Mascota.Domain.Ports.MascotaRepository;

import java.util.Optional;

public class MascotaFinder {
    private final MascotaRepository repository;

    public MascotaFinder(MascotaRepository repository) {
        this.repository = repository;
    }
    public Mascota execute(String id)
    {
        Optional<Mascota> result = repository.find(id);
        if (result.isEmpty())
        {
            throw new RuntimeException("Error");
        }
        Mascota mascota = result.get();
        return mascota;
    }

}
