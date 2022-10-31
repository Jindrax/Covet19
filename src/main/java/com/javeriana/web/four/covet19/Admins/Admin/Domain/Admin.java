package com.javeriana.web.four.covet19.Admins.Admin.Domain;

import com.javeriana.web.four.covet19.Shared.Domain.Admin.PersonCreatedDomainEvent;
import com.javeriana.web.four.covet19.Shared.Domain.Aggregate.AggregateRoot;
import com.javeriana.web.four.covet19.Shared.Domain.Persona.ValueObjects.*;
import com.javeriana.web.four.covet19.Shared.Domain.Security.Auth.AuthCredentials;
import com.javeriana.web.four.covet19.Shared.Domain.Security.Auth.AuthEntity;
import com.javeriana.web.four.covet19.Shared.Domain.Security.Auth.Exceptions.IncorrectCredentials;

import java.util.HashMap;

public class Admin extends AggregateRoot implements AuthEntity{
    private IdPersona idAdmin;
    private CedulaPersona cedulaAdmin;
    private NombrePersona nombreAdmin;
    private TelefonoPersona telefonoAdmin;
    private CorreoPersona correoAdmin;
    private DireccionPersona direccionAdmin;
    private PasswordPersona passwordAdmin;
    private FechaNacimientoPersona fechaNacimientoAdmin;

    public Admin(IdPersona idAdmin, CedulaPersona cedulaAdmin, NombrePersona nombreAdmin, TelefonoPersona telefonoAdmin, CorreoPersona correoAdmin, DireccionPersona direccionAdmin, PasswordPersona passwordAdmin, FechaNacimientoPersona fechaNacimientoAdmin) {
        this.idAdmin = idAdmin;
        this.cedulaAdmin = cedulaAdmin;
        this.nombreAdmin = nombreAdmin;
        this.telefonoAdmin = telefonoAdmin;
        this.correoAdmin = correoAdmin;
        this.direccionAdmin = direccionAdmin;
        this.passwordAdmin = passwordAdmin;
        this.fechaNacimientoAdmin = fechaNacimientoAdmin;
    }

    public Admin() {
    }

    public HashMap<String, Object> data() {
        return new HashMap<>() {{
            put("id", idAdmin.value());
            put("cedula", cedulaAdmin.value());
            put("nombre", nombreAdmin.value());
            put("telefono", telefonoAdmin.value());
            put("correo", correoAdmin.value());
            put("direccion", direccionAdmin.value());
            put("fechaNacimiento", fechaNacimientoAdmin.value());
        }};
    }

    public static Admin create(String idAdmin, long cedulaAdmin, String nombreAdmin, long telefonoAdmin, String correoAdmin, String direccionAdmin, String passwordAdmin, String fechaNacimientoAdmin) {
        Admin newAdmin = new Admin(new IdPersona(idAdmin),
                new CedulaPersona(cedulaAdmin),
                new NombrePersona(nombreAdmin),
                new TelefonoPersona(telefonoAdmin),
                new CorreoPersona(correoAdmin),
                new DireccionPersona(direccionAdmin),
                new PasswordPersona(passwordAdmin),
                new FechaNacimientoPersona(fechaNacimientoAdmin));
        newAdmin.record(new PersonCreatedDomainEvent(newAdmin.idAdmin.value(), newAdmin.correoAdmin.value(), Admin.class.getName()));
        return newAdmin;
    }

    @Override
    public AuthCredentials getCredentials(String supposedPass) throws IncorrectCredentials {
        if (passwordAdmin.equals(new PasswordPersona(supposedPass))) {
            String authorities = "ROLE_ADMIN";
            return new AuthCredentials(idAdmin.value(), authorities, new HashMap<String, Object>());
        } else {
            throw new IncorrectCredentials("Credenciales incorrectas");
        }
    }

    @Override
    public HashMap<String, Object> dataToAuth() {
        HashMap<String, Object> ret = this.data();
        ret.put("rol", "admin");
        return ret;
    }

    public void updateCedula(long cedula){
        this.cedulaAdmin = new CedulaPersona(cedula);
    }

    public void updateNombre(String nombre){
        this.nombreAdmin = new NombrePersona(nombre);
    }

    public void updateCorreo(String correo){
        this.correoAdmin = new CorreoPersona(correo);
    }

    public void updateDireccion(String direccion){
        this.direccionAdmin = new DireccionPersona(direccion);
    }

    public void updatePassword(String password){
        this.passwordAdmin = new PasswordPersona(password);
    }

    public void updateFechaNacimiento(String fechaNacimiento){
        this.fechaNacimientoAdmin = new FechaNacimientoPersona(fechaNacimiento);
    }

    public void updateTelefonoAdmin(long telefono){
        this.telefonoAdmin = new TelefonoPersona(telefono);
    }
}
