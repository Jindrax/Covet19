package com.javeriana.web.four.covet19.Veterinarios.Veterinario.Application.VeterinarioModificarFechaCita;

import com.javeriana.web.four.covet19.Veterinarios.Veterinario.Domain.Exceptions.VeterinarioNoExiste;
import com.javeriana.web.four.covet19.Veterinarios.Veterinario.Domain.Ports.VeterinarioRepository;
import com.javeriana.web.four.covet19.Veterinarios.Veterinario.Domain.Veterinario;

import java.util.Optional;

public class VeterinarioModificarFechaCita {
    private VeterinarioRepository repository;

    public VeterinarioModificarFechaCita(VeterinarioRepository repository) {
        this.repository = repository;
    }
    public void execute(String idVeterinario, String idCita, String fechaCita){
        Optional<Veterinario> veterinario = repository.find(idVeterinario);
        if (veterinario.isEmpty())
        {
            throw new VeterinarioNoExiste(idVeterinario);
        }
        Veterinario finalVeterinario = veterinario.get();
        finalVeterinario.updateCitaFecha(idCita, fechaCita);
        repository.update(finalVeterinario);
    }
}
