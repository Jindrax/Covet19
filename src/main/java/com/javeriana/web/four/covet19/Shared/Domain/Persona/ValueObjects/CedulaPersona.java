package com.javeriana.web.four.covet19.Shared.Domain.Persona.ValueObjects;

import com.javeriana.web.four.covet19.Shared.Domain.LongValueObject;

public class CedulaPersona extends LongValueObject {

    private CedulaPersona() {}

    public CedulaPersona(Long cedula) {
        this.validate(cedula);
        this.value = cedula;
    }

    private void validate(Long cedula) {
        if (cedula < 0)
        {
            throw new RuntimeException("La cédula: " +  cedula + " no puede ser negativa");
        }
    }

}
