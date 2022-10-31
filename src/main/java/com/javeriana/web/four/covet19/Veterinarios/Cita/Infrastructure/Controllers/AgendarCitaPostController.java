package com.javeriana.web.four.covet19.Veterinarios.Cita.Infrastructure.Controllers;


import com.javeriana.web.four.covet19.Veterinarios.Cita.Application.Create.AgendarCita;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/cita")
public class AgendarCitaPostController {

    @Autowired
    private AgendarCita creator;

    @PostMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity execute(@RequestBody Request request){
        HttpStatus codigo = HttpStatus.CREATED;

        creator.execute(request.getId(), request.getDiagnostico(), request.getFecha(),
                request.getIdVeterinario(), request.getIdMascota(), request.getIdUsuario());

        return  ResponseEntity.status(codigo).body(null);
    }
    static class Request {

        private String id;
        private String diagnostico;
        private String fecha;
        private String idVeterinario;
        private String idMascota;
        private String idUsuario;

        public String getIdUsuario() {
            return idUsuario;
        }

        public void setIdUsuario(String idUsuario) {
            this.idUsuario = idUsuario;
        }

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

        public String getFecha() {
            return fecha;
        }

        public void setFecha(String fecha) {
            this.fecha = fecha;
        }

        public String getIdVeterinario() {
            return idVeterinario;
        }

        public void setIdVeterinario(String idVeterinario) {
            this.idVeterinario = idVeterinario;
        }

        public String getIdMascota() {
            return idMascota;
        }

        public void setIdMascota(String idMascota) {
            this.idMascota = idMascota;
        }
    }

}
