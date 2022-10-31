package com.javeriana.web.four.covet19.Veterinarios.Veterinario.Domain;

import com.javeriana.web.four.covet19.Shared.Domain.Admin.PersonCreatedDomainEvent;
import com.javeriana.web.four.covet19.Shared.Domain.Aggregate.AggregateRoot;
import com.javeriana.web.four.covet19.Shared.Domain.Persona.ValueObjects.*;
import com.javeriana.web.four.covet19.Shared.Domain.Security.Auth.AuthCredentials;
import com.javeriana.web.four.covet19.Shared.Domain.Security.Auth.AuthEntity;
import com.javeriana.web.four.covet19.Shared.Domain.Security.Auth.Exceptions.IncorrectCredentials;
import com.javeriana.web.four.covet19.Veterinarios.Veterinario.Domain.ValueObjects.CitaDetails;
import com.javeriana.web.four.covet19.Veterinarios.Veterinario.Domain.ValueObjects.TarjetaProfesionalVeterinario;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Veterinario extends AggregateRoot implements AuthEntity {

    private IdPersona idVeterinario;
    private CedulaPersona cedulaVeterinario;
    private CorreoPersona correoVeterinario;
    private DireccionPersona direccionVeterinario;
    private FechaNacimientoPersona fechaNacimientoVeterinario;
    private NombrePersona nombreVeterinario;
    private PasswordPersona passwordVeterinario;
    private TelefonoPersona telefonoVeterinario;
    private TarjetaProfesionalVeterinario tarjetaProfesionalVeterinario;
    private Optional<List<CitaDetails>> agendaVeterinario;


    public Veterinario(
            IdPersona idVeterinario,
            CedulaPersona cedulaVeterinario,
            CorreoPersona correoVeterinario,
            DireccionPersona direccionVeterinario,
            FechaNacimientoPersona fechaNacimientoVeterinario,
            NombrePersona nombreVeterinario,
            PasswordPersona passwordVeterinario,
            TelefonoPersona telefonoVeterinario,
            TarjetaProfesionalVeterinario tarjetaProfesionalVeterinario,
            List<CitaDetails> agendaVeterinario
    ) {
        this.idVeterinario = idVeterinario;
        this.cedulaVeterinario = cedulaVeterinario;
        this.correoVeterinario = correoVeterinario;
        this.direccionVeterinario = direccionVeterinario;
        this.fechaNacimientoVeterinario = fechaNacimientoVeterinario;
        this.nombreVeterinario = nombreVeterinario;
        this.passwordVeterinario = passwordVeterinario;
        this.telefonoVeterinario = telefonoVeterinario;
        this.tarjetaProfesionalVeterinario = tarjetaProfesionalVeterinario;
        this.agendaVeterinario = Optional.ofNullable(agendaVeterinario);
    }

    public static Veterinario create(
            IdPersona idPersona,
            CedulaPersona cedulaPersona,
            CorreoPersona correoPersona,
            DireccionPersona direccionPersona,
            FechaNacimientoPersona fechaNacimientoPersona,
            NombrePersona nombrePersona,
            PasswordPersona passwordPersona,
            TelefonoPersona telefonoPersona,
            TarjetaProfesionalVeterinario tarjetaProfesionalVeterinario
    ) {
        Veterinario newVet = new Veterinario(idPersona,
                cedulaPersona,
                correoPersona,
                direccionPersona,
                fechaNacimientoPersona,
                nombrePersona,
                passwordPersona,
                telefonoPersona,
                tarjetaProfesionalVeterinario,
                null);
        newVet.record(new PersonCreatedDomainEvent(idPersona.value(), correoPersona.value(), Veterinario.class.getName()));
        return newVet;
    }

    public void update(
            CedulaPersona cedulaPersona,
            CorreoPersona correoPersona,
            DireccionPersona direccionPersona,
            FechaNacimientoPersona fechaNacimientoPersona,
            NombrePersona nombrePersona,
            PasswordPersona passwordPersona,
            TelefonoPersona telefonoPersona,
            TarjetaProfesionalVeterinario tarjetaProfesionalVeterinario
    ) {
        this.cedulaVeterinario = cedulaPersona;
        this.correoVeterinario = correoPersona;
        this.direccionVeterinario = direccionPersona;
        this.fechaNacimientoVeterinario = fechaNacimientoPersona;
        this.nombreVeterinario = nombrePersona;
        this.passwordVeterinario = passwordPersona;
        this.telefonoVeterinario = telefonoPersona;
        this.tarjetaProfesionalVeterinario = tarjetaProfesionalVeterinario;
    }

    public Optional<List<HashMap<String, Object>>> getAgendaVeterinario() {
        Optional<List<HashMap<String, Object>>> response = Optional.empty();
        if (this.agendaVeterinario.isPresent()) {
            response = Optional.of(this.agendaVeterinario.get().stream().map(cita -> cita.data()).collect(Collectors.toList()));
        }
        return response;
    }

    public void addCitaDetails(CitaDetails citaDetails) {
        List<CitaDetails> productColorDetailsList =
                this.agendaVeterinario.isEmpty() ? new ArrayList<>() : this.agendaVeterinario.get();
        productColorDetailsList.add(citaDetails);
        this.agendaVeterinario = Optional.ofNullable(productColorDetailsList);
    }

    public void updateCitaDetails(CitaDetails citaDetails) {
        List<CitaDetails> citasDetailsList = this.agendaVeterinario.get();
        CitaDetails citaDetailsActual = citasDetailsList.stream().
                filter(cita -> cita.equalsIdCita(citaDetails)).findFirst().get();
        citasDetailsList.remove(citaDetailsActual);
        citasDetailsList.add(citaDetails);
        this.agendaVeterinario = Optional.ofNullable(citasDetailsList);
    }

    public void updateCitaDiagnostico(String idCita, String diagnostico) {
        List<CitaDetails> citasDetailsList = this.agendaVeterinario.get();
        CitaDetails citaDetailsActual = citasDetailsList.stream().
                filter(cita -> cita.equalsIdCita(idCita)).findFirst().get();
        citaDetailsActual.updateDiagnostico(diagnostico);
        this.agendaVeterinario = Optional.ofNullable(citasDetailsList);
    }

    public void updateCitaFecha(String idCita, String fecha) {
        List<CitaDetails> citasDetailsList = this.agendaVeterinario.get();
        CitaDetails citaDetailsActual = citasDetailsList.stream().
                filter(cita -> cita.equalsIdCita(idCita)).findFirst().get();
        citaDetailsActual.updateFecha(fecha);
        this.agendaVeterinario = Optional.ofNullable(citasDetailsList);
    }

    public void agregarCita(String idCita, String diagnostico, String fecha, String idMascota) {
        List<CitaDetails> citasDetailsList = this.agendaVeterinario.isEmpty() ? new ArrayList<CitaDetails>() : this.agendaVeterinario.get();
        CitaDetails citaNueva = new CitaDetails(idCita, diagnostico, fecha, idMascota);
        citasDetailsList.add(citaNueva);
        this.agendaVeterinario = Optional.ofNullable(citasDetailsList);
    }

    public void eliminarCita(CitaDetails eliminarCita) {
        List<CitaDetails> citasDetailsList = this.agendaVeterinario.get();
        CitaDetails eliminar = citasDetailsList.stream().filter(cita -> cita.equalsIdCita(eliminarCita)).findFirst().get();
        citasDetailsList.remove(eliminar);
        this.agendaVeterinario = Optional.ofNullable(citasDetailsList);
    }

    public Optional<List<CitaDetails>> getAgenda() {
        return agendaVeterinario;
    }

    public HashMap<String, Object> data() {
        return new HashMap<String, Object>() {{
            put("id", idVeterinario.value());
            put("cedula", cedulaVeterinario.value());
            put("correo", correoVeterinario.value());
            put("direccion", direccionVeterinario.value());
            put("fechaNacimiento", fechaNacimientoVeterinario.value().toString());
            put("nombre", nombreVeterinario.value());
            put("password", passwordVeterinario.value());
            put("telefono", telefonoVeterinario.value());
            put("tarjetaProfesional", tarjetaProfesionalVeterinario.value());
            put("agenda", getAgendaVeterinario());
        }};
    }

    private Veterinario() {
    }

    public String getCorreoVeterinario() {
        return correoVeterinario.value();
    }

    public String getNombreVeterinario() {
        return nombreVeterinario.value();
    }

    @Override
    public AuthCredentials getCredentials(String supposedPass) throws IncorrectCredentials {
        if (passwordVeterinario.equals(new PasswordPersona(supposedPass))) {
            String authorities = "ROLE_VETERINARIO";
            return new AuthCredentials(idVeterinario.value(), authorities, new HashMap<String, Object>());
        } else {
            throw new IncorrectCredentials("Credenciales incorrectas");
        }
    }

    @Override
    public HashMap<String, Object> dataToAuth() {
        HashMap<String, Object> ret = this.data();
        ret.put("rol", "vet");
        return ret;
    }
}
