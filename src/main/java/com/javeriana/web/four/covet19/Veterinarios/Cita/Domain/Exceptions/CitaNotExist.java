package com.javeriana.web.four.covet19.Veterinarios.Cita.Domain.Exceptions;

public class CitaNotExist extends RuntimeException{
    public CitaNotExist(String message) {
        super(message);
    }
}
