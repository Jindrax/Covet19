package com.javeriana.web.four.covet19.Veterinarios.Cita.Application.All;

import com.javeriana.web.four.covet19.Veterinarios.Cita.Domain.Cita;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class CitaAllResponse {
    private final List<Cita> citas;

    public  CitaAllResponse(List<Cita> citas){this.citas = citas; }

    public  List<HashMap> response(){
        List<HashMap> response = citas.stream().map(p -> p.data()).collect(Collectors.toList());
        return response;
    }
}
