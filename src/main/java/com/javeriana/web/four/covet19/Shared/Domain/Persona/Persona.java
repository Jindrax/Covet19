package com.javeriana.web.four.covet19.Shared.Domain.Persona;

import com.javeriana.web.four.covet19.Shared.Domain.Persona.ValueObjects.*;

import java.util.Objects;

public class Persona {

    private IdPersona idPersona;
    private CedulaPersona cedulaPersona;
    private CorreoPersona correoPersona;
    private DireccionPersona direccionPersona;
    private FechaNacimientoPersona fechaNacimientoPersona;
    private NombrePersona nombrePersona;
    private PasswordPersona passwordPersona;
    private TelefonoPersona telefonoPersona;

    public Persona(
            IdPersona idPersona,
            CedulaPersona cedulaPersona,
            CorreoPersona correoPersona,
            DireccionPersona direccionPersona,
            FechaNacimientoPersona fechaNacimientoPersona,
            NombrePersona nombrePersona,
            PasswordPersona passwordPersona,
            TelefonoPersona telefonoPersona
    ) {
        this.idPersona = idPersona;
        this.cedulaPersona = cedulaPersona;
        this.correoPersona = correoPersona;
        this.direccionPersona = direccionPersona;
        this.fechaNacimientoPersona = fechaNacimientoPersona;
        this.nombrePersona = nombrePersona;
        this.passwordPersona = passwordPersona;
        this.telefonoPersona = telefonoPersona;
    }

    public static Persona create(
            IdPersona idPersona,
            CedulaPersona cedulaPersona,
            CorreoPersona correoPersona,
            DireccionPersona direccionPersona,
            FechaNacimientoPersona fechaNacimientoPersona,
            NombrePersona nombrePersona,
            PasswordPersona passwordPersona,
            TelefonoPersona telefonoPersona
    ) {
        return new Persona(idPersona, cedulaPersona, correoPersona, direccionPersona, fechaNacimientoPersona, nombrePersona, passwordPersona, telefonoPersona);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Persona persona = (Persona) o;
        return Objects.equals(idPersona, persona.idPersona) &&
                Objects.equals(nombrePersona, persona.nombrePersona) &&
                Objects.equals(correoPersona, persona.correoPersona);
    }

    private Persona() {}

}
