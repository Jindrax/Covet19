package com.javeriana.web.four.covet19.Admins.Admin.Application.Update;

import com.javeriana.web.four.covet19.Admins.Admin.Application.Find.FindAdmin;
import com.javeriana.web.four.covet19.Admins.Admin.Domain.Admin;
import com.javeriana.web.four.covet19.Admins.Admin.Infrastructure.Controllers.UpdateAdminRequest;
import com.javeriana.web.four.covet19.Admins.Admin.Infrastructure.Hibernate.HibernateAdminRepository;
import com.javeriana.web.four.covet19.Productos.Producto.Application.Exceptions.NotFound;

import java.util.Optional;


public class UpdateAdmin {

    private final HibernateAdminRepository repository;

    public UpdateAdmin(HibernateAdminRepository repository) {
        this.repository = repository;
    }

    public void execute(UpdateAdminRequest request) {
        if(request.getId().isEmpty()){
            throw new NotFound("Falta el id del admin");
        }
        Optional<Admin> admin = new FindAdmin(repository).execute(request.getId().get());
        if(admin.isEmpty()){
            throw new NotFound("No se ha encontrado el admin");
        }
        if (request.getNombre().isPresent()) {
            admin.get().updateNombre(request.getNombre().get());
        }
        if (request.getTelefono().isPresent()) {
            admin.get().updateTelefonoAdmin(request.getTelefono().get());
        }
        if (request.getDireccion().isPresent()) {
            admin.get().updateDireccion(request.getDireccion().get());
        }
        if (request.getPass().isPresent()) {
            admin.get().updatePassword(request.getPass().get());
        }
        if (request.getFechaNacimiento().isPresent()) {
            admin.get().updateFechaNacimiento(request.getFechaNacimiento().get());
        }
        repository.update(admin.get());
    }
}
