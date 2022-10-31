package com.javeriana.web.four.covet19.Usuarios.User.Infrastructure.Controllers;

import com.javeriana.web.four.covet19.Usuarios.User.Application.FindMascotaByUsuario.UserFinderMascotas;
import com.javeriana.web.four.covet19.Usuarios.User.Application.FindMascotaByUsuario.UserFinderMascotasResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;


@RestController
@RequestMapping(value = "/users")
public class FindMascotasUserByIdGetController {
    @Autowired
    private UserFinderMascotas finder;

    @GetMapping(value="/findMascotas/{id}")
    public ResponseEntity<List<HashMap>> execute(@PathVariable("id") String id)
    {
        UserFinderMascotasResponse response = new UserFinderMascotasResponse(finder.execute(id));
        return ResponseEntity.status(HttpStatus.OK).body(response.response());
    }
}
