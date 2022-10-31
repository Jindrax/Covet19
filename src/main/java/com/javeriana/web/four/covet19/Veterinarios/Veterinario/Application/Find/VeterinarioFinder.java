package com.javeriana.web.four.covet19.Veterinarios.Veterinario.Application.Find;

import com.javeriana.web.four.covet19.Veterinarios.Veterinario.Domain.Exceptions.VeterinarioNoExiste;
import com.javeriana.web.four.covet19.Veterinarios.Veterinario.Domain.Ports.VeterinarioRepository;
import com.javeriana.web.four.covet19.Veterinarios.Veterinario.Domain.Veterinario;

import java.util.Optional;

public class VeterinarioFinder {

    private final VeterinarioRepository repository;

    public VeterinarioFinder(VeterinarioRepository repository) {
        this.repository = repository;
    }

    public Veterinario execute(String idVeterinario) {
        Optional<Veterinario> veterinario = repository.find(idVeterinario);
        if (veterinario.isEmpty())
        {
            throw new VeterinarioNoExiste(idVeterinario);
        }
        Veterinario finalVeterinario = veterinario.get();
        return finalVeterinario;
    }

}
