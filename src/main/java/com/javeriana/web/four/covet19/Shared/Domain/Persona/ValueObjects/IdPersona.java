package com.javeriana.web.four.covet19.Shared.Domain.Persona.ValueObjects;

import com.javeriana.web.four.covet19.Shared.Domain.CustomUUID;

import java.io.Serializable;

public class IdPersona extends CustomUUID implements Serializable
{
    private IdPersona() {
        super("");
    }

    public IdPersona(String value) {
        super(value);
    }
}