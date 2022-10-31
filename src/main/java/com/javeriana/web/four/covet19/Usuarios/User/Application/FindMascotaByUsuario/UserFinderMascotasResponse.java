package com.javeriana.web.four.covet19.Usuarios.User.Application.FindMascotaByUsuario;

import com.javeriana.web.four.covet19.Usuarios.User.Domain.ValueObjects.MascotaDetails;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class UserFinderMascotasResponse {

    private final List<MascotaDetails> mascotas;

    public UserFinderMascotasResponse(List<MascotaDetails>  mascotas) {
        this.mascotas = mascotas;
    }

    public List<HashMap> response()
    {
        List<HashMap> response = mascotas.stream().map(c -> c.data()).collect(Collectors.toList());
        return response;
    }
}
