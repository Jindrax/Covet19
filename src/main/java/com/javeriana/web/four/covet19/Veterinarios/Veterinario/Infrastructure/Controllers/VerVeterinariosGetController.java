package com.javeriana.web.four.covet19.Veterinarios.Veterinario.Infrastructure.Controllers;

import com.javeriana.web.four.covet19.Veterinarios.Veterinario.Application.VerVeterinarios.VeterinarioVerVeterinarios;
import com.javeriana.web.four.covet19.Veterinarios.Veterinario.Application.VerVeterinarios.VeterinarioVerVeterinariosResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping(value = "/veterinarios")
public class VerVeterinariosGetController {

    @Autowired
    private VeterinarioVerVeterinarios verVeterinarios;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<HashMap>> execute()
    {
        VeterinarioVerVeterinariosResponse response = new VeterinarioVerVeterinariosResponse(verVeterinarios.execute());
        return ResponseEntity.status(HttpStatus.OK).body(response.response());
    }

}
