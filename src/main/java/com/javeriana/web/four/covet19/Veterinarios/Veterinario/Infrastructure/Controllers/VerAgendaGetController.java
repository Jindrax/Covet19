package com.javeriana.web.four.covet19.Veterinarios.Veterinario.Infrastructure.Controllers;

import com.javeriana.web.four.covet19.Veterinarios.Veterinario.Application.VerAgenda.VeterinarioVerAgenda;
import com.javeriana.web.four.covet19.Veterinarios.Veterinario.Application.VerAgenda.VeterinarioVerAgendaResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping(value = "/veterinarios")
public class VerAgendaGetController {

    @Autowired
    private VeterinarioVerAgenda verAgenda;

    @GetMapping(value = "/{id}/agenda", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<HashMap>> execute(@PathVariable("id") String idVeterinario)
    {
        VeterinarioVerAgendaResponse response = new VeterinarioVerAgendaResponse(verAgenda.execute(idVeterinario));
        return ResponseEntity.status(HttpStatus.OK).body(response.response());
    }

}
