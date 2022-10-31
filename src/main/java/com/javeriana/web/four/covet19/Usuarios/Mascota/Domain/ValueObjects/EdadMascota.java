package com.javeriana.web.four.covet19.Usuarios.Mascota.Domain.ValueObjects;

import com.javeriana.web.four.covet19.Shared.Domain.IntegerValueObject;

public class EdadMascota extends IntegerValueObject {
    private EdadMascota() {
    }

    public EdadMascota(Integer edad) {
        this.validate(edad);
        this.value = edad;
    }

    private void validate(Integer edad) {
    }
}