package com.javeriana.web.four.covet19.Usuarios.Mascota.Domain.ValueObjects;

import com.javeriana.web.four.covet19.Shared.Domain.DoubleValueObject;

public class PesoMascota extends DoubleValueObject {
    private PesoMascota() {
    }

    public PesoMascota(Double pesoMascota) {
        this.validate(pesoMascota);
        this.value = pesoMascota;
    }

    private void validate(Double pesoMascota) {
    }
}
