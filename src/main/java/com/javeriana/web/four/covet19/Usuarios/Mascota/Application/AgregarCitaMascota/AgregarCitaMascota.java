package com.javeriana.web.four.covet19.Usuarios.Mascota.Application.AgregarCitaMascota;

import com.javeriana.web.four.covet19.Usuarios.Mascota.Domain.Mascota;
import com.javeriana.web.four.covet19.Usuarios.Mascota.Domain.Ports.MascotaRepository;

import java.util.Optional;

public class AgregarCitaMascota {

    private MascotaRepository repository;

    public AgregarCitaMascota(MascotaRepository repository) {
        this.repository = repository;
    }

    public  void execute (String idMascota, String idCita, String diagnostico, String fecha, String idVeterinario){
        Optional<Mascota> mascota = repository.find(idMascota);
        if (mascota.isEmpty())
        {
            throw new RuntimeException("La Mascota con Id: " + idMascota + " no existe");
        }
        Mascota finalMascota = mascota.get();
        finalMascota.agregarCita(idCita, diagnostico, fecha, idVeterinario);
        repository.update(finalMascota);
    }
}
