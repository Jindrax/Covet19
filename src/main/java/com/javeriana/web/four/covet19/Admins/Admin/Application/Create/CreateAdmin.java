package com.javeriana.web.four.covet19.Admins.Admin.Application.Create;

import com.javeriana.web.four.covet19.Admins.Admin.Domain.Admin;
import com.javeriana.web.four.covet19.Admins.Admin.Infrastructure.Hibernate.HibernateAdminRepository;
import com.javeriana.web.four.covet19.Shared.Domain.Bus.Event.EventBus;

public class CreateAdmin {

    private final HibernateAdminRepository repository;
    private final EventBus eventBus;

    public CreateAdmin(HibernateAdminRepository repository, EventBus eventBus) {
        this.repository = repository;
        this.eventBus = eventBus;
    }

    public void execute(String idAdmin, long cedulaAdmin, String nombreAdmin, long telefonoAdmin, String correoAdmin, String direccionAdmin, String passwordAdmin, String fechaNacimientoAdmin){
        Admin admin = Admin.create(idAdmin, cedulaAdmin, nombreAdmin, telefonoAdmin, correoAdmin, direccionAdmin, passwordAdmin, fechaNacimientoAdmin);
        repository.save(admin);
        eventBus.publish(admin.pullDomainEvents());
    }
}
