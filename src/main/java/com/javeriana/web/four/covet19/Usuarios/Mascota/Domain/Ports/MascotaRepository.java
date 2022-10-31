package com.javeriana.web.four.covet19.Usuarios.Mascota.Domain.Ports;

import com.javeriana.web.four.covet19.Usuarios.Mascota.Domain.Mascota;

import java.util.List;
import java.util.Optional;

public interface MascotaRepository {
    void update(Mascota mascota);
    Optional<Mascota> find (String idMascota);
    void save(Mascota mascota);
    Optional<List<Mascota>> all();
}
