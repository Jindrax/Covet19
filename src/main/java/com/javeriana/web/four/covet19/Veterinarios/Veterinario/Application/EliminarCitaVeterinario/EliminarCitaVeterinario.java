package com.javeriana.web.four.covet19.Veterinarios.Veterinario.Application.EliminarCitaVeterinario;

import com.javeriana.web.four.covet19.Veterinarios.Veterinario.Domain.Ports.VeterinarioRepository;
import com.javeriana.web.four.covet19.Veterinarios.Veterinario.Domain.ValueObjects.CitaDetails;
import com.javeriana.web.four.covet19.Veterinarios.Veterinario.Domain.Veterinario;

import java.util.Optional;

public class EliminarCitaVeterinario {
    private final VeterinarioRepository repository;

    public EliminarCitaVeterinario(VeterinarioRepository repository) {
        this.repository = repository;
    }
    public void execute (String idVeterinario, String idCita){
        Optional<Veterinario> veterinario = repository.find(idVeterinario);
        if (veterinario.isEmpty()){
            throw new RuntimeException("el veterinario con Id: " + idVeterinario + " no existe");
        }
        Veterinario finalVeterinario= veterinario.get();
        finalVeterinario.eliminarCita(CitaDetails.createCitaId(idCita));
        repository.update(finalVeterinario);
    }
}
