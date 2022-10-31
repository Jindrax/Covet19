package com.javeriana.web.four.covet19.Usuarios.User.Application.VerCitasAgendadas;

import com.javeriana.web.four.covet19.Veterinarios.Cita.Domain.Cita;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class VerCitasAgendadasResponse {
    public final List<Cita> citas;

    public VerCitasAgendadasResponse(List<Cita> citas) {
        this.citas = citas;
    }
    public List<HashMap> response(){
        List<HashMap> response = citas.stream().map(c ->c.data()).collect(Collectors.toList());
        return response;
    }
}

