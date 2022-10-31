package com.javeriana.web.four.covet19.Usuarios.Mascota.Application.EliminarCitaMascota;

import com.javeriana.web.four.covet19.Usuarios.Mascota.Domain.Mascota;
import com.javeriana.web.four.covet19.Usuarios.Mascota.Domain.Ports.MascotaRepository;
import com.javeriana.web.four.covet19.Usuarios.Mascota.Domain.ValueObjects.CitaHistorialMascota;

import java.util.Optional;

public class EliminarCitaMascota {
    private final MascotaRepository repository;

    public EliminarCitaMascota(MascotaRepository repository) {
        this.repository = repository;
    }

    public void execute(String idMascota, String idCita){
        Optional<Mascota> mascota = repository.find(idMascota);
        if (mascota.isEmpty()){
            throw new RuntimeException("la mascota con Id: " + idMascota + " no existe");
        }
        Mascota finalMascota = mascota.get();
        finalMascota.eliminarCita(CitaHistorialMascota.createCitaId(idCita));
        repository.update(finalMascota);

    }
}
