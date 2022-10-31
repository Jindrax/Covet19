package com.javeriana.web.four.covet19.Usuarios.Mascota.Domain.ValueObjects;

import com.javeriana.web.four.covet19.Shared.Domain.StringValueObject;

public class NombreMascota extends StringValueObject {
    private NombreMascota() {
    }

    public NombreMascota(String nombre) {
        this.validate(nombre);
        this.value = nombre;
    }

    private void validate(String nombre) {
    }
}
