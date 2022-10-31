package com.javeriana.web.four.covet19.Usuarios.Mascota.Domain.ValueObjects;

import com.javeriana.web.four.covet19.Shared.Domain.StringValueObject;

public class TipoMascota extends StringValueObject {
    private TipoMascota() {
    }

    public TipoMascota(String tipo) {
        this.validate(tipo);
        this.value = tipo;
    }

    private void validate(String tipo) {
    }
}

