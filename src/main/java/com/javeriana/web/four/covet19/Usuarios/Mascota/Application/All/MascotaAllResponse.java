package com.javeriana.web.four.covet19.Usuarios.Mascota.Application.All;

import com.javeriana.web.four.covet19.Usuarios.Mascota.Domain.Mascota;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class MascotaAllResponse {
    private final List<Mascota> mascotas;

    public MascotaAllResponse(List<Mascota> mascotas) {
        this.mascotas = mascotas;
    }

    public List<HashMap> response()
    {
        List<HashMap> response = mascotas.stream().map(p -> p.data()).collect(Collectors.toList());
        return response;
    }
}
