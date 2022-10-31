package com.javeriana.web.four.covet19.Veterinarios.Cita.Infrastructure.Controllers;

import com.javeriana.web.four.covet19.Veterinarios.Cita.Application.VerCita.CitaVerCita;
import com.javeriana.web.four.covet19.Veterinarios.Cita.Domain.Cita;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
@RequestMapping(value = "/citas")
public class VerCitaGetController {

    @Autowired
    private CitaVerCita verCita;

    @GetMapping(value="/ver/{idCita}")
    public ResponseEntity<HashMap> execute(@PathVariable("idCita") String idCita)
    {
        Cita cita = verCita.execute(idCita);
        return ResponseEntity.status(HttpStatus.OK).body(cita.data());
    }
}
