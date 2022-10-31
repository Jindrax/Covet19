package com.javeriana.web.four.covet19.Usuarios.Mascota.Application.ModificarFechaCita;

import com.javeriana.web.four.covet19.Usuarios.Mascota.Domain.Mascota;
import com.javeriana.web.four.covet19.Usuarios.Mascota.Domain.Ports.MascotaRepository;

import java.util.Optional;

public class MascotaModificarFechaCita {
    private MascotaRepository repository;

    public MascotaModificarFechaCita(MascotaRepository repository) {
        this.repository = repository;
    }
    public void execute(String idMascota, String idCita, String fechaCita){
        Optional<Mascota> mascota = repository.find(idMascota);
        if (mascota.isEmpty())
        {
            throw new RuntimeException("La Mascota con Id: " + idMascota + " no existe");
        }
        Mascota finalMascota = mascota.get();
        finalMascota.updateCitaFecha(idCita, fechaCita);
        repository.update(finalMascota);

    }

}
