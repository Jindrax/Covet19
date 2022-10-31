package com.javeriana.web.four.covet19.Shared.Domain.HistorialClinico;

import com.javeriana.web.four.covet19.Shared.Domain.CustomUUID;

public class IdHistorial extends CustomUUID
{
    private IdHistorial() {
        super("");
    }

    public IdHistorial(String value) {
        super(value);
    }
}
