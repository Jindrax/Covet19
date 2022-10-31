package com.javeriana.web.four.covet19.Usuarios.User.Infrastructure.Controllers;

import com.javeriana.web.four.covet19.Shared.Domain.UUIDNotValid;
import com.javeriana.web.four.covet19.Usuarios.User.Application.Create.UserCreator;
import com.javeriana.web.four.covet19.Usuarios.User.Domain.Exceptions.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

@RestController
@RequestMapping(value = "/user")
public final class CreateUserPostController {

    @Autowired
    private UserCreator creator;

    @PostMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity execute(@RequestBody Request request) {
        try {
            Date fecha = new SimpleDateFormat("yyyy-MM-dd").parse(request.getFecha());
            creator.execute(request.getId(), request.getNombre(), request.getPassword(), request.getCorreo(), request.getTelefono(), request.getCedula(), request.getDireccion(), fecha);
            System.out.println("Estoy llegando antes de devolver");
            return ResponseEntity.status(HttpStatus.CREATED).body(null);
        } catch (ParseException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @ExceptionHandler({UUIDNotValid.class, UpperLowerError.class, NotSymbolsFound.class, LengthNotValid.class})
    public ResponseEntity<HashMap> hanldleDataErrors(RuntimeException exception) {
        HashMap<String, String> response = new HashMap<String, String>() {{
            put("error", exception.getMessage());
        }};
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }

    @ExceptionHandler(BadWordsError.class)
    public ResponseEntity<HashMap> hanldleBadWords(BadWordsError exception) {
        HashMap<String, String> response = new HashMap<String, String>() {{
            put("error", exception.getMessage());
        }};
        return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(response);
    }

    @ExceptionHandler(UserAlreadyExists.class)
    public ResponseEntity<HashMap> hanldleUserAlreadyExist(UserAlreadyExists exception) {
        HashMap<String, String> response = new HashMap<String, String>() {{
            put("error", exception.getMessage());
        }};
        return ResponseEntity.status(HttpStatus.CONFLICT).body(response);
    }
}

class Request {
    private String id;
    private String nombre;
    private String password;
    private String correo;
    private Long telefono;
    private Long cedula;
    private String direccion;
    private String fecha;
    private String carrito;
    private String mascotas;

    public String getCarrito() {
        return carrito;
    }

    public void setCarrito(String carrito) {
        this.carrito = carrito;
    }

    public String getMascotas() {
        return mascotas;
    }

    public void setMascotas(String mascotas) {
        this.mascotas = mascotas;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public Long getTelefono() {
        return telefono;
    }

    public void setTelefono(Long telefono) {
        this.telefono = telefono;
    }

    public Long getCedula() {
        return cedula;
    }

    public void setCedula(Long cedula) {
        this.cedula = cedula;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
}
