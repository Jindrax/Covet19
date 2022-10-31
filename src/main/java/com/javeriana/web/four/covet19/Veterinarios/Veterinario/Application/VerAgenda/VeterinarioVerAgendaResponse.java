package com.javeriana.web.four.covet19.Veterinarios.Veterinario.Application.VerAgenda;

import com.javeriana.web.four.covet19.Veterinarios.Veterinario.Domain.ValueObjects.CitaDetails;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class VeterinarioVerAgendaResponse {

    private final List<CitaDetails> citas;

    public VeterinarioVerAgendaResponse(List<CitaDetails> citas) {
        this.citas = citas;
    }

    public List<HashMap> response() {
        List<HashMap> response = citas.stream().map(c -> c.data()).collect(Collectors.toList());
        return response;
    }

}
