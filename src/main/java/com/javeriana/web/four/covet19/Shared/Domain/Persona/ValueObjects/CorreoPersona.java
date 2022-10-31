package com.javeriana.web.four.covet19.Shared.Domain.Persona.ValueObjects;

import com.javeriana.web.four.covet19.Shared.Domain.StringValueObject;

import java.io.Serializable;

public class CorreoPersona extends StringValueObject implements Serializable {

    private CorreoPersona() {}

    public CorreoPersona(String correo) {
        this.validate(correo);
        this.value = correo;
    }

    private void validate(String correo) {
    }

}
