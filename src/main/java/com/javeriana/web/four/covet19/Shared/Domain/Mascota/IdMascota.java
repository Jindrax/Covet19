package com.javeriana.web.four.covet19.Shared.Domain.Mascota;

import com.javeriana.web.four.covet19.Shared.Domain.CustomUUID;

public class IdMascota extends CustomUUID {
    
    private IdMascota() {
        super("");
    }

    public IdMascota(String value) {
        super(value);
    }
}
