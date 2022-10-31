package com.javeriana.web.four.covet19.Veterinarios.Cita.Infrastructure.Controllers;

import com.javeriana.web.four.covet19.Veterinarios.Cita.Application.AgregarDiagnostico.CitaAgregarDiagnostico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/citas")
public class AgregarDiagnosticoPostController {

    @Autowired
    private CitaAgregarDiagnostico agregarDiagnostico;

    @PostMapping(value = "/agregarDiagnostico", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity execute(@RequestBody Request request) {
        agregarDiagnostico.execute(request.getId(), request.getDiagnostico());
        return ResponseEntity.status(HttpStatus.OK).body(null);
    }

    static class Request {
        private String id;
        private String diagnostico;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getDiagnostico() {
            return diagnostico;
        }

        public void setDiagnostico(String diagnostico) {
            this.diagnostico = diagnostico;
        }
    }
}
