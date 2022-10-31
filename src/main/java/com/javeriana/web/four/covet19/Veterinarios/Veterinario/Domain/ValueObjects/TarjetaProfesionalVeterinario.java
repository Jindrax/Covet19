package com.javeriana.web.four.covet19.Veterinarios.Veterinario.Domain.ValueObjects;

import com.javeriana.web.four.covet19.Shared.Domain.StringValueObject;

public class TarjetaProfesionalVeterinario extends StringValueObject {

    private TarjetaProfesionalVeterinario() {}

    public TarjetaProfesionalVeterinario(String tarjeta) {
        this.validate(tarjeta);
        this.value = tarjeta;
    }

    private void validate(String tarjeta) {
    }

}
