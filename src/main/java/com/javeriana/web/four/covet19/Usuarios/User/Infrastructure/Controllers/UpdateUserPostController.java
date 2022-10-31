package com.javeriana.web.four.covet19.Usuarios.User.Infrastructure.Controllers;


import com.javeriana.web.four.covet19.Shared.Domain.UUIDNotValid;
import com.javeriana.web.four.covet19.Usuarios.User.Application.UpdateUser.UpdateUser;
import com.javeriana.web.four.covet19.Usuarios.User.Domain.Exceptions.BadWordsError;
import com.javeriana.web.four.covet19.Usuarios.User.Domain.Exceptions.LengthNotValid;
import com.javeriana.web.four.covet19.Usuarios.User.Domain.Exceptions.NotSymbolsFound;
import com.javeriana.web.four.covet19.Usuarios.User.Domain.Exceptions.UpperLowerError;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@RequestMapping(value = "/users")
public class UpdateUserPostController {

    @Autowired
    private UpdateUser updateUser;

    @PostMapping(value = "/update", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity execute(@RequestBody UpdateUserPostController.Request request) {
        updateUser.execute(request.getId(),request.getNombre(),request.getPassword(),request.getCorreo(),request.getTelefono(),request.getCedula(),request.getDireccion(),request.getFechaNacimiento());
        return ResponseEntity.status(HttpStatus.OK).body(null);
    }
    @ExceptionHandler({UUIDNotValid.class, UpperLowerError.class, NotSymbolsFound.class, LengthNotValid.class})
    public ResponseEntity<HashMap> hanldleDataErrors(RuntimeException exception)
    {
        HashMap<String, String> response = new HashMap<String, String>() {{
            put("error", exception.getMessage());
        }};
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }

    @ExceptionHandler(BadWordsError.class)
    public ResponseEntity<HashMap> hanldleBadWords(BadWordsError exception)
    {
        HashMap<String, String> response = new HashMap<String, String>() {{
            put("error", exception.getMessage());
        }};
        return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(response);
    }

    static class Request {
        private String id;
        private String nombre;
        private String password;
        private String correo;
        private Long telefono;
        private Long cedula;
        private String direccion;
        private String fechaNacimiento;


        public String getId() {
            return id;
        }

        public String getNombre() {
            return nombre;
        }

        public String getPassword() {
            return password;
        }

        public String getCorreo() {
            return correo;
        }

        public Long getTelefono() {
            return telefono;
        }

        public Long getCedula() {
            return cedula;
        }

        public String getDireccion() {
            return direccion;
        }

        public String getFechaNacimiento() {
            return fechaNacimiento;
        }

    }
}