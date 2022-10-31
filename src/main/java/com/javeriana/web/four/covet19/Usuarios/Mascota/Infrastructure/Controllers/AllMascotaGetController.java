package com.javeriana.web.four.covet19.Usuarios.Mascota.Infrastructure.Controllers;


import com.javeriana.web.four.covet19.Usuarios.Mascota.Application.All.MascotaAll;
import com.javeriana.web.four.covet19.Usuarios.Mascota.Application.All.MascotaAllResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping(value = "/mascotas")
public class AllMascotaGetController {
    @Autowired
    private MascotaAll mascotaAll;

    @GetMapping
    public ResponseEntity<List<HashMap>> execute()
    {
        MascotaAllResponse response = new MascotaAllResponse(mascotaAll.execute());
        return ResponseEntity.status(HttpStatus.OK).body(response.response());
    }
}
