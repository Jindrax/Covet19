package com.javeriana.web.four.covet19.Veterinarios.Veterinario.Infrastructure.Controllers;

import com.javeriana.web.four.covet19.Veterinarios.Veterinario.Application.Create.VeterinarioCreator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
@RequestMapping(value = "/veterinarios")
public class CreateVeterinarioPostController {

    @Autowired
    private VeterinarioCreator creator;

    @PostMapping(value = "/new", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity execute(@RequestBody Request request)
    {
        HttpStatus codigo = HttpStatus.CREATED;
        try {
            Date fecha = new SimpleDateFormat("yyyy-MM-dd").parse(request.getFechaNacimiento());
            creator.execute(
                    request.getId(),
                    request.getCedula(),
                    request.getCorreo(),
                    request.getDireccion(),
                    fecha,
                    request.getNombre(),
                    request.getPassword(),
                    request.getTelefono(),
                    request.getTarjetaProfesional());
        } catch (ParseException e) {
            codigo = HttpStatus.INTERNAL_SERVER_ERROR;
            e.printStackTrace();
        }
        return ResponseEntity.status(codigo).body(null);
    }

    static class Request {
        private String id;
        private long cedula;
        private String correo;
        private String direccion;
        private String fechaNacimiento;
        private String nombre;
        private String password;
        private long telefono;
        private String tarjetaProfesional;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public long getCedula() {
            return cedula;
        }

        public void setCedula(long cedula) {
            this.cedula = cedula;
        }

        public String getCorreo() {
            return correo;
        }

        public void setCorreo(String correo) {
            this.correo = correo;
        }

        public String getDireccion() {
            return direccion;
        }

        public void setDireccion(String direccion) {
            this.direccion = direccion;
        }

        public String getFechaNacimiento() {
            return fechaNacimiento;
        }

        public void setFechaNacimiento(String fechaNacimiento) {
            this.fechaNacimiento = fechaNacimiento;
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

        public long getTelefono() {
            return telefono;
        }

        public void setTelefono(long telefono) {
            this.telefono = telefono;
        }

        public String getTarjetaProfesional() {
            return tarjetaProfesional;
        }

        public void setTarjetaProfesional(String tarjetaProfesional) {
            this.tarjetaProfesional = tarjetaProfesional;
        }
    }

}
