package com.javeriana.web.four.covet19.Veterinarios.Cita.Infrastructure.Controllers;

import com.javeriana.web.four.covet19.Veterinarios.Cita.Application.Update.CitaUpdate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/citas")
public class UpdateCitaPostController {

    @Autowired
    private CitaUpdate update;

    @PostMapping(value = "/{idCita}/update", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity execute(@RequestBody Request request, @PathVariable("idCita") String idCita)
    {
        HttpStatus codigo = HttpStatus.CREATED;
        update.execute(idCita, request.getDiagnostico(), request.getFecha());
        return ResponseEntity.status(codigo).body(null);
    }

    static class Request {
        private String id;
        private String fecha;
        private String diagnostico;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getFecha() {
            return fecha;
        }

        public void setFecha(String fecha) {
            this.fecha = fecha;
        }

        public String getDiagnostico() {
            return diagnostico;
        }

        public void setDiagnostico(String diagnostico) {
            this.diagnostico = diagnostico;
        }
    }
}
