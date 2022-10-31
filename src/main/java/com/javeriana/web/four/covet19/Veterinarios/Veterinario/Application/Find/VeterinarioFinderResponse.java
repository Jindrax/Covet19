package com.javeriana.web.four.covet19.Veterinarios.Veterinario.Application.Find;

import com.javeriana.web.four.covet19.Veterinarios.Veterinario.Domain.Veterinario;

import java.util.HashMap;

public class VeterinarioFinderResponse {

    private final Veterinario veterinario;

    public VeterinarioFinderResponse(Veterinario veterinario) {
        this.veterinario = veterinario;
    }

    public HashMap response() {
        HashMap<String, Object> response = veterinario.data();
        return response;
    }

}
