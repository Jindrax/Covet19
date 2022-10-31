package com.javeriana.web.four.covet19.Veterinarios.Veterinario.Application.AgregarCitaVeterinario;

import com.javeriana.web.four.covet19.Veterinarios.Veterinario.Domain.Ports.VeterinarioRepository;
import com.javeriana.web.four.covet19.Veterinarios.Veterinario.Domain.Veterinario;

import java.util.Optional;

public class AgregarCitaVeterinario {

    private VeterinarioRepository repository;

    public AgregarCitaVeterinario(VeterinarioRepository repository) {
        this.repository = repository;
    }

    public void execute (String idVeterinario, String idCita, String diagnostico, String fecha, String idMascota){
        Optional<Veterinario> veterinario = repository.find(idVeterinario);
        if (veterinario.isEmpty())
        {
            throw new RuntimeException("el veterinario con Id: " + idVeterinario + " no existe");
        }
        Veterinario finalVeterinario = veterinario.get();
        finalVeterinario.agregarCita(idCita,diagnostico, fecha, idMascota);
        repository.update(finalVeterinario);
    }
}