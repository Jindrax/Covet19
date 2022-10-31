package com.javeriana.web.four.covet19.Usuarios.Mascota.Application.All;

import com.javeriana.web.four.covet19.Usuarios.Mascota.Domain.Mascota;
import com.javeriana.web.four.covet19.Usuarios.Mascota.Domain.Ports.MascotaRepository;

import java.util.List;
import java.util.Optional;

public class MascotaAll {
    private final MascotaRepository repository;

    public MascotaAll(MascotaRepository repository) {
        this.repository = repository;
    }

    public List<Mascota> execute()
    {
        System.out.println();
        Optional<List<Mascota>> mascotas = repository.all();
        if (mascotas.isEmpty())
        {
            throw new RuntimeException("Error");
        }
        return mascotas.get();
    }
}
