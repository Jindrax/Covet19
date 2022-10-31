package com.javeriana.web.four.covet19.Usuarios.User.Application.UpdateMascotaUsuario;

import com.javeriana.web.four.covet19.Usuarios.Mascota.Application.Find.MascotaFinder;
import com.javeriana.web.four.covet19.Usuarios.Mascota.Domain.Exceptions.MascotaNotExist;
import com.javeriana.web.four.covet19.Usuarios.Mascota.Domain.Mascota;
import com.javeriana.web.four.covet19.Usuarios.User.Domain.Exceptions.UserNotExist;
import com.javeriana.web.four.covet19.Usuarios.User.Domain.Ports.UserRepository;
import com.javeriana.web.four.covet19.Usuarios.User.Domain.User;
import com.javeriana.web.four.covet19.Usuarios.User.Domain.ValueObjects.MascotaDetails;

import java.util.HashMap;
import java.util.Optional;


public class UpdateMascota {
    private final UserRepository repository;
    private final MascotaFinder finderMascota;

    public UpdateMascota(UserRepository repository, MascotaFinder updateMascota) {
        this.repository = repository;
        this.finderMascota = updateMascota;
    }

    public void execute(String idUsuario, Mascota mascotaActualizada){
        Optional<User> usuario = repository.find(idUsuario);
        if (usuario.isEmpty())
        {
            throw new UserNotExist(idUsuario);
        }
        User finalUser = usuario.get();
        Mascota mascota = finderMascota.execute(mascotaActualizada.getIdMascota().value());
        if (mascota==null)
        {
            throw new MascotaNotExist(mascotaActualizada.getIdMascota().toString());
        }
        HashMap<String, Object> infoMacota = mascotaActualizada.data();
        MascotaDetails element = new MascotaDetails(
                String.valueOf(infoMacota.get("id")),
                (int) infoMacota.get("edad"),
                String.valueOf(infoMacota.get("edad")),
                String.valueOf(infoMacota.get("tipo")),
                String.valueOf(infoMacota.get("raza")));

        if(finalUser.updateMascota(element)){
            repository.update( finalUser.getUserId().toString(),finalUser);
        }else {
            throw new MascotaNotExist("La mascota no existe update");
        }

    }
}