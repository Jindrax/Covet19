package com.javeriana.web.four.covet19.Veterinarios.Veterinario.Infrastructure.Controllers;

import com.javeriana.web.four.covet19.Veterinarios.Veterinario.Application.Find.VeterinarioFinder;
import com.javeriana.web.four.covet19.Veterinarios.Veterinario.Application.Find.VeterinarioFinderResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
@RequestMapping(value = "/veterinario")
public class FindVeterinarioGetController {

    @Autowired
    private VeterinarioFinder finder;

    @GetMapping(value = "/{idVet}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<HashMap> execute(@PathVariable("idVet") String idVeterinario)
    {
        VeterinarioFinderResponse response = new VeterinarioFinderResponse(finder.execute(idVeterinario));
        return ResponseEntity.status(HttpStatus.OK).body(response.response());
    }

}
