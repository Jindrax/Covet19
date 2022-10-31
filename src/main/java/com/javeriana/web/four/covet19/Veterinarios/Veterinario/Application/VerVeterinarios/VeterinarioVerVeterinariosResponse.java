package com.javeriana.web.four.covet19.Veterinarios.Veterinario.Application.VerVeterinarios;

import com.javeriana.web.four.covet19.Veterinarios.Veterinario.Domain.Veterinario;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class VeterinarioVerVeterinariosResponse {

    private final List<Veterinario> veterinarios;

    public VeterinarioVerVeterinariosResponse(List<Veterinario> veterinarios) {
        this.veterinarios = veterinarios;
    }

    public List<HashMap> response() {
        List<HashMap> response = veterinarios.stream().map(v -> v.data()).collect(Collectors.toList());
        return response;
    }

}
