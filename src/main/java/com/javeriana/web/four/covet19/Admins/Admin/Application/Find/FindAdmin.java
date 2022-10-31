package com.javeriana.web.four.covet19.Admins.Admin.Application.Find;

import com.javeriana.web.four.covet19.Admins.Admin.Domain.Admin;
import com.javeriana.web.four.covet19.Admins.Admin.Infrastructure.Hibernate.HibernateAdminRepository;

import java.util.Optional;

public class FindAdmin {

    private final HibernateAdminRepository repository;

    public FindAdmin(HibernateAdminRepository repository) {
        this.repository = repository;
    }

    public Optional<Admin> execute(String idAdmin) {
        return repository.find(idAdmin);
    }
}
