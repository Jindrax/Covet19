package com.javeriana.web.four.covet19.Veterinarios.Cita.Domain.ValueObjects;

import com.javeriana.web.four.covet19.Shared.Domain.DateValueObject;

import java.util.Calendar;
import java.util.Date;

public class FechaCita extends DateValueObject {
    
    private FechaCita() {}

    public FechaCita(Date fecha) {
        this.validate(fecha);
        value = fecha;
    }

    private void validate(Date fecha) {
        Calendar currentCalendar = Calendar.getInstance();
        Date ahora = currentCalendar.getTime();
        int comparacion = fecha.compareTo(ahora);
        if (fecha.compareTo(ahora) < 0)
        {
            throw new RuntimeException("La fecha de la cita: " +  fecha + " es invalida");
        }
    }
}
