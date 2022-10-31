package com.javeriana.web.four.covet19.Usuarios.Mascota.Domain.ValueObjects;

import com.javeriana.web.four.covet19.Shared.Domain.StringValueObject;

public class RazaMascota extends StringValueObject {
    private RazaMascota() {
    }

    public RazaMascota(String raza) {
        this.validate(raza);
        this.value = raza;
    }

    private void validate(String raza) {
    }
}
