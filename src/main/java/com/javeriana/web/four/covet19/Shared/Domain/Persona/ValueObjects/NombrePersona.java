package com.javeriana.web.four.covet19.Shared.Domain.Persona.ValueObjects;

import com.javeriana.web.four.covet19.Shared.Domain.StringValueObject;

public class NombrePersona extends StringValueObject {

    private NombrePersona() {}

    public NombrePersona(String nombre) {
        this.validate(nombre);
        this.value = nombre;
    }

    private void validate(String nombre) {
    }

}
