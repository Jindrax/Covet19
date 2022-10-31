package com.javeriana.web.four.covet19.Veterinarios.Veterinario.Application.ModificarCitaDiagnostico;

import com.javeriana.web.four.covet19.Veterinarios.Veterinario.Domain.Exceptions.VeterinarioNoExiste;
import com.javeriana.web.four.covet19.Veterinarios.Veterinario.Domain.Ports.VeterinarioRepository;
import com.javeriana.web.four.covet19.Veterinarios.Veterinario.Domain.Veterinario;

import java.util.Optional;

public class VeterinarioModificarCitaDiagnostico {
    private final VeterinarioRepository repository;

    public VeterinarioModificarCitaDiagnostico(VeterinarioRepository repository) {
        this.repository = repository;
    }

    public void execute(String idVeterinario, String idCita, String diagnostico)
    {
        Optional<Veterinario> veterinario = repository.find(idVeterinario);
        if (veterinario.isEmpty())
        {
            throw new VeterinarioNoExiste(idVeterinario);
        }
        Veterinario finalVeterinario = veterinario.get();
        finalVeterinario.updateCitaDiagnostico(idCita, diagnostico);
        repository.update(finalVeterinario);
    }
}
