package com.javeriana.web.four.covet19.Veterinarios.Cita.Infrastructure.Controllers;

import com.javeriana.web.four.covet19.Veterinarios.Cita.Application.Delete.DeleteCita;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/citas")
public class DeleteCitaGetController {

    @Autowired
    private DeleteCita eliminarCita;

    @GetMapping(value = "/delete/{idCita}")
    public void execute(@PathVariable("idCita") String idCita){
        HttpStatus codigo = HttpStatus.CREATED;
        eliminarCita.execute(idCita);
    }
}
