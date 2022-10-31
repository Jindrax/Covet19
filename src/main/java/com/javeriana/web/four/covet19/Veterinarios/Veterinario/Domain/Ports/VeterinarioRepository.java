package com.javeriana.web.four.covet19.Veterinarios.Veterinario.Domain.Ports;

import com.javeriana.web.four.covet19.Veterinarios.Veterinario.Domain.Veterinario;

import java.util.List;
import java.util.Optional;

public interface VeterinarioRepository {
    
    void update(Veterinario veterinario);
    Optional<Veterinario> find (String idVeterinario);
    void save(Veterinario veterinario);
    Optional<List<Veterinario>> all();
}
