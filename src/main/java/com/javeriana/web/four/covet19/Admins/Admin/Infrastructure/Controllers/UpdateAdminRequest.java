package com.javeriana.web.four.covet19.Admins.Admin.Infrastructure.Controllers;

import java.util.Optional;

public class UpdateAdminRequest {
    private Optional<String> id;
    private Optional<String> nombre;
    private Optional<Long> telefono;
    private Optional<String> direccion;
    private Optional<String> pass;
    private Optional<String> fechaNacimiento;

    public UpdateAdminRequest() {
        this.id = Optional.empty();
        this.nombre = Optional.empty();
        this.telefono = Optional.empty();
        this.direccion = Optional.empty();
        this.pass = Optional.empty();
        this.fechaNacimiento = Optional.empty();
    }

    public Optional<String> getId() {
        return id;
    }

    public Optional<String> getNombre() {
        return nombre;
    }

    public Optional<Long> getTelefono() {
        return telefono;
    }

    public Optional<String> getDireccion() {
        return direccion;
    }

    public Optional<String> getPass() {
        return pass;
    }

    public Optional<String> getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setId(String id) {
        this.id = Optional.ofNullable(id);
    }

    public void setNombre(String nombre) {
        this.nombre = Optional.ofNullable(nombre);
    }

    public void setTelefono(Long telefono) {
        this.telefono = Optional.ofNullable(telefono);
    }

    public void setDireccion(String direccion) {
        this.direccion = Optional.ofNullable(direccion);
    }

    public void setPass(String pass) {
        this.pass = Optional.ofNullable(pass);
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = Optional.ofNullable(fechaNacimiento);
    }
}
