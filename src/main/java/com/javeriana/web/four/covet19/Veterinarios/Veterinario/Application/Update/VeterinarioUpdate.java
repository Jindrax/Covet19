package com.javeriana.web.four.covet19.Veterinarios.Veterinario.Application.Update;

import com.javeriana.web.four.covet19.Shared.Domain.Persona.ValueObjects.*;
import com.javeriana.web.four.covet19.Veterinarios.Veterinario.Domain.Exceptions.VeterinarioNoExiste;
import com.javeriana.web.four.covet19.Veterinarios.Veterinario.Domain.Ports.VeterinarioRepository;
import com.javeriana.web.four.covet19.Veterinarios.Veterinario.Domain.ValueObjects.TarjetaProfesionalVeterinario;
import com.javeriana.web.four.covet19.Veterinarios.Veterinario.Domain.Veterinario;

import java.util.Date;
import java.util.Optional;

public class VeterinarioUpdate {

    VeterinarioRepository repository;

    public VeterinarioUpdate(VeterinarioRepository repository) {
        this.repository = repository;
    }

    public void execute(String idVeterinario,
                        long cedulaVeterinario,
                        String correoVeterinario,
                        String direccionVeterinario,
                        Date fechaNacimientoVeterinario,
                        String nombreVeterinario,
                        String passwordVeterinario,
                        long telefonoVeterinario,
                        String tarjetaProfesionalVeterinario
    ) {

        Optional<Veterinario> veterinario = repository.find(idVeterinario);

        if (veterinario.isEmpty())
        {
            throw new VeterinarioNoExiste(idVeterinario);
        }

        Veterinario veterinarioTemp = veterinario.get();

        veterinarioTemp.update(
                new CedulaPersona(cedulaVeterinario),
                new CorreoPersona(correoVeterinario),
                new DireccionPersona(direccionVeterinario),
                new FechaNacimientoPersona(fechaNacimientoVeterinario),
                new NombrePersona(nombreVeterinario),
                new PasswordPersona(passwordVeterinario),
                new TelefonoPersona(telefonoVeterinario),
                new TarjetaProfesionalVeterinario(tarjetaProfesionalVeterinario));

        repository.update(veterinarioTemp);
    }

}
