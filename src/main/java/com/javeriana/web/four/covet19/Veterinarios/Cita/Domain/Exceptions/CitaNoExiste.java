package com.javeriana.web.four.covet19.Veterinarios.Cita.Domain.Exceptions;

public class CitaNoExiste extends RuntimeException{
    public CitaNoExiste(String idCita) {
        super("La cita con Id: " + idCita + " no existe");
    }
}
