package com.javeriana.web.four.covet19.Usuarios.Mascota.Application.Find;

import com.javeriana.web.four.covet19.Shared.Application.Response;
import com.javeriana.web.four.covet19.Usuarios.Mascota.Domain.Mascota;

import java.util.HashMap;

public class MascotaFinderResponse implements Response {

    private final Mascota mascota;
    private HashMap<String, Object> response;
    @Override
    public HashMap<String, Object> response() {
        this.response = mascota.data();
        return this.response;
    }
    public MascotaFinderResponse(Mascota mascota) {
        this.mascota = mascota;
    }
}
