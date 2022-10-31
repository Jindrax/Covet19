package com.javeriana.web.four.covet19.Admins.Admin.Domain.Exceptions;

public class AdminNoExiste extends RuntimeException{

    public AdminNoExiste(String idAdmin) {
        super("El Admin con Id: " + idAdmin + " no existe");
    }

}
