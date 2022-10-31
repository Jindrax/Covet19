package com.javeriana.web.four.covet19.Shared.Domain.Persona.ValueObjects;

import com.javeriana.web.four.covet19.Shared.Domain.LongValueObject;

public class TelefonoPersona extends LongValueObject {

    private TelefonoPersona() {}

    public TelefonoPersona(Long telefono) {
        this.validate(telefono);
        this.value = telefono;
    }

    private void validate(Long telefono) {
        if (telefono < 0)
        {
            throw new RuntimeException("El teléfono: " +  telefono + " no puede ser negativo");
        }
    }

}
