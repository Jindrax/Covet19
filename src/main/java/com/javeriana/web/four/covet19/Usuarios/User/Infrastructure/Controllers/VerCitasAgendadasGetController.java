package com.javeriana.web.four.covet19.Usuarios.User.Infrastructure.Controllers;

import com.javeriana.web.four.covet19.Usuarios.User.Application.VerCitasAgendadas.VerCitasAgendadas;
import com.javeriana.web.four.covet19.Usuarios.User.Application.VerCitasAgendadas.VerCitasAgendadasResponse;
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
@RequestMapping(value = "/users")
public class VerCitasAgendadasGetController {
    @Autowired
    private VerCitasAgendadas verCitasAgendadas;

    @GetMapping(value = "/{idUsuario}/verCitasAgendadas", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<HashMap>> execute(@PathVariable("idUsuario") String idUsuario){
        HttpStatus codigo = HttpStatus.CREATED;
        VerCitasAgendadasResponse response = new VerCitasAgendadasResponse(verCitasAgendadas.execute(idUsuario));
        return ResponseEntity.status(codigo).body(response.response());
    }
}
