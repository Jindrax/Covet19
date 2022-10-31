package com.javeriana.web.four.covet19.Shared.Domain.Citas;

import com.javeriana.web.four.covet19.Shared.Domain.CustomUUID;

public class IdCita extends CustomUUID
{
    private IdCita() {
        super("");
    }

    public IdCita(String value) {
        super(value);
    }
}
