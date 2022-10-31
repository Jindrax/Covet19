package com.javeriana.web.four.covet19.Veterinarios.Cita.Application.Delete;

import com.javeriana.web.four.covet19.Usuarios.Mascota.Application.EliminarCitaMascota.EliminarCitaMascota;
import com.javeriana.web.four.covet19.Veterinarios.Cita.Domain.Cita;
import com.javeriana.web.four.covet19.Veterinarios.Cita.Domain.Exceptions.CitaNoExiste;
import com.javeriana.web.four.covet19.Veterinarios.Cita.Domain.Ports.CitaRepository;
import com.javeriana.web.four.covet19.Veterinarios.Veterinario.Application.EliminarCitaVeterinario.EliminarCitaVeterinario;

import java.util.Optional;

public class DeleteCita {
    private final CitaRepository repository;
    private final EliminarCitaVeterinario eliminarCitaVeterinario;
    private final EliminarCitaMascota eliminarCitaMascota;

    public DeleteCita(CitaRepository repository, EliminarCitaVeterinario eliminarCitaVeterinario, EliminarCitaMascota eliminarCitaMascota) {
        this.repository = repository;
        this.eliminarCitaVeterinario = eliminarCitaVeterinario;
        this.eliminarCitaMascota = eliminarCitaMascota;
    }
    public void execute(String idCita){
        Optional<Cita> eliminarCita = repository.find(idCita);
        if (eliminarCita.isEmpty()){
            throw new CitaNoExiste(idCita);
        }
        Cita eliminar = eliminarCita.get();
        eliminarCitaVeterinario.execute(eliminar.getIdVeterinario(), idCita);
        eliminarCitaMascota.execute(eliminar.getIdMascota(),idCita);
        repository.delete(eliminar);

    }
}
