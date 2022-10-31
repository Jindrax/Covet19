package com.javeriana.web.four.covet19.Usuarios.User.Application.VerCitasAgendadas;

import com.javeriana.web.four.covet19.Usuarios.User.Domain.Exceptions.UserNotExist;
import com.javeriana.web.four.covet19.Usuarios.User.Domain.Ports.UserRepository;
import com.javeriana.web.four.covet19.Usuarios.User.Domain.User;
import com.javeriana.web.four.covet19.Veterinarios.Cita.Application.All.CitaAll;
import com.javeriana.web.four.covet19.Veterinarios.Cita.Domain.Cita;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class VerCitasAgendadas {
    private final UserRepository repository;
    private final CitaAll citas;

    public VerCitasAgendadas(UserRepository repository, CitaAll citas) {
        this.repository = repository;
        this.citas = citas;
    }
    public List<Cita> execute(String idUsuario){
        Optional<User> usuario = repository.find(idUsuario);
        if(usuario.isEmpty()){
            throw new UserNotExist(idUsuario);
        }
        List<Cita> totalCitas = citas.execute();
        List<Cita> citasAgendadas = totalCitas.stream().filter(cita -> cita.getIdUsuario().equals(idUsuario)).collect(Collectors.toList());
        return citasAgendadas;

    }
}
