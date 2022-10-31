package com.javeriana.web.four.covet19.Usuarios.User.Application.FindMascotaByUsuario;


import com.javeriana.web.four.covet19.Usuarios.User.Domain.Exceptions.UserNotExist;
import com.javeriana.web.four.covet19.Usuarios.User.Domain.Ports.UserRepository;
import com.javeriana.web.four.covet19.Usuarios.User.Domain.User;
import com.javeriana.web.four.covet19.Usuarios.User.Domain.ValueObjects.MascotaDetails;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserFinderMascotas {

    private UserRepository repository;

    public UserFinderMascotas(UserRepository repository) {
        this.repository = repository;
    }

    public List<MascotaDetails> execute(String userId) {
        List<MascotaDetails> userMascotas = new ArrayList<>();
        Optional<User> user = repository.find(userId);
        if(user.isEmpty()){
            throw new UserNotExist("User not exist");
        }
        User userFinal = user.get();
        if(!userFinal.getUserMascotas().isEmpty()) {
            userMascotas = userFinal.getUserMascotasDetails().get();
        }
        return userMascotas;
    }
    public UserFinderMascotas(){}
}
