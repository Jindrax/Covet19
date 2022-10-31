package com.javeriana.web.four.covet19.Veterinarios.Veterinario.Domain.Exceptions;

public class VeterinarioNoExiste extends RuntimeException{
    public VeterinarioNoExiste(String idVeterinario) {
        super("El Veterinario con Id: " + idVeterinario + " no existe");
    }
}
