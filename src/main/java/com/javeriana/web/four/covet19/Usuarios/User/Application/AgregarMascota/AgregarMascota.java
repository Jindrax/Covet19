package com.javeriana.web.four.covet19.Usuarios.User.Application.AgregarMascota;

import com.javeriana.web.four.covet19.Usuarios.Mascota.Application.Find.MascotaFinder;
import com.javeriana.web.four.covet19.Usuarios.Mascota.Domain.Mascota;
import com.javeriana.web.four.covet19.Usuarios.User.Domain.Exceptions.UserNotExist;
import com.javeriana.web.four.covet19.Usuarios.User.Domain.Ports.UserRepository;
import com.javeriana.web.four.covet19.Usuarios.User.Domain.User;
import com.javeriana.web.four.covet19.Usuarios.User.Domain.ValueObjects.MascotaDetails;

import java.util.HashMap;
import java.util.Optional;

public class AgregarMascota {
    private final UserRepository repository;

    public AgregarMascota(UserRepository repository) {
        this.repository = repository;
    }

    public void execute(String idUsuario, Mascota mascota){
        Optional<User> usuario = repository.find(idUsuario);
        if (usuario.isEmpty())
        {
            throw new UserNotExist(idUsuario);
        }
        User finalUser = usuario.get();
        HashMap<String, Object> infoMacota = mascota.data();
        MascotaDetails element = new MascotaDetails(
                String.valueOf(infoMacota.get("id")),
                (int) infoMacota.get("edad"),
                String.valueOf(infoMacota.get("edad")),
                String.valueOf(infoMacota.get("tipo")),
                String.valueOf(infoMacota.get("raza")));

        finalUser.addMascotasDetails(element);
        repository.update( finalUser.getUserId().toString(),finalUser);
    }
}
