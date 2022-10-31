package com.javeriana.web.four.covet19.Shared.Domain.Persona.ValueObjects;

import com.javeriana.web.four.covet19.Shared.Domain.DateValueObject;
import com.javeriana.web.four.covet19.Shared.Domain.Persona.Exceptions.DateBadFormat;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class FechaNacimientoPersona extends DateValueObject {

    private FechaNacimientoPersona() {
    }

    public FechaNacimientoPersona(String fecha) {
        try {
            Date fechaDate = new SimpleDateFormat("yyyy-MM-dd").parse(fecha);
            this.validate(fechaDate);
            this.value = fechaDate;
        } catch (ParseException e) {
            throw new DateBadFormat("Formato erroneo de fecha, formato admitido 'yyyy-MM-dd'");
        }
    }

    public FechaNacimientoPersona(Date fecha) {
        this.validate(fecha);
        this.value = fecha;
    }

    private void validate(Date fecha) {
        Calendar currentCalendar = Calendar.getInstance();
        if (fecha.compareTo(currentCalendar.getTime()) > 0) {
            throw new RuntimeException("La fecha de nacimiento: " + fecha + " es invalida");
        }
    }

}
