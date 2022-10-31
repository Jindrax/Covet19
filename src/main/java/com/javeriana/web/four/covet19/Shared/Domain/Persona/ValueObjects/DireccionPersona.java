package com.javeriana.web.four.covet19.Shared.Domain.Persona.ValueObjects;

import com.javeriana.web.four.covet19.Shared.Domain.StringValueObject;

public class DireccionPersona extends StringValueObject {
    
    private DireccionPersona() {}

    public DireccionPersona(String direccion) {
        this.validate(direccion);
        this.value = direccion;
    }

    private void validate(String direccion) {
    }

}
