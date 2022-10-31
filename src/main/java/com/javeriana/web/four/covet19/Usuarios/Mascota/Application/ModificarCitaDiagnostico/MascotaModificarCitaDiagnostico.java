package com.javeriana.web.four.covet19.Usuarios.Mascota.Application.ModificarCitaDiagnostico;

import com.javeriana.web.four.covet19.Usuarios.Mascota.Domain.Mascota;
import com.javeriana.web.four.covet19.Usuarios.Mascota.Domain.Ports.MascotaRepository;

import java.util.Optional;

public class MascotaModificarCitaDiagnostico {

    private final MascotaRepository repository;

    public MascotaModificarCitaDiagnostico(MascotaRepository repository) {
        this.repository = repository;
    }

    public void execute(String idMascota, String idCita, String diagnostico)
    {
        Optional<Mascota> mascota = repository.find(idMascota);
        if (mascota.isEmpty())
        {
            throw new RuntimeException("La Mascota con Id: " + idMascota + " no existe");
        }
        Mascota finalMascota = mascota.get();
        finalMascota.updateCitaDiagnostico(idCita, diagnostico);
        repository.update(finalMascota);
    }

}
