package com.javeriana.web.four.covet19.Veterinarios.Veterinario.Application.VerAgenda;

import com.javeriana.web.four.covet19.Veterinarios.Veterinario.Domain.Exceptions.VeterinarioNoExiste;
import com.javeriana.web.four.covet19.Veterinarios.Veterinario.Domain.Ports.VeterinarioRepository;
import com.javeriana.web.four.covet19.Veterinarios.Veterinario.Domain.ValueObjects.CitaDetails;
import com.javeriana.web.four.covet19.Veterinarios.Veterinario.Domain.Veterinario;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class VeterinarioVerAgenda {
    private final VeterinarioRepository repository;

    public VeterinarioVerAgenda(VeterinarioRepository repository) {
        this.repository = repository;
    }

    public List<CitaDetails> execute(String idVeterinario)
    {
        Optional<Veterinario> veterinario = repository.find(idVeterinario);
        if (veterinario.isEmpty())
        {
            throw new VeterinarioNoExiste(idVeterinario);
        }
        List<CitaDetails> result = new ArrayList<>();
        Veterinario finalVeterinario = veterinario.get();
        if(!finalVeterinario.getAgenda().isEmpty()) {
            result = finalVeterinario.getAgenda().get();
        }
        return result;
    }
}
