package com.javeriana.web.four.covet19.Usuarios.Mascota.Infrastructure.Controllers;


import com.javeriana.web.four.covet19.Usuarios.Mascota.Application.Find.MascotaFinder;
import com.javeriana.web.four.covet19.Usuarios.Mascota.Domain.Mascota;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
@RequestMapping(value = "/mascotas")
public class FindMascotaByIdGetController {
    @Autowired
    private MascotaFinder finder;

    @GetMapping(value="/{id}")
    public ResponseEntity<HashMap> execute(@PathVariable("id") String id)
    {
        Mascota mascota = finder.execute(id);
        return ResponseEntity.status(HttpStatus.OK).body(mascota.data());
    }
}
