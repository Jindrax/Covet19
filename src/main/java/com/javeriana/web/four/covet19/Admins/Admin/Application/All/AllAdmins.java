package com.javeriana.web.four.covet19.Admins.Admin.Application.All;

import com.javeriana.web.four.covet19.Admins.Admin.Domain.Admin;
import com.javeriana.web.four.covet19.Admins.Admin.Infrastructure.Hibernate.HibernateAdminRepository;

import java.util.ArrayList;
import java.util.List;

public class AllAdmins {

    private final HibernateAdminRepository repository;

    public AllAdmins(HibernateAdminRepository repository) {
        this.repository = repository;
    }

    public List<Admin> execute() {
        return repository.all().orElse(new ArrayList<Admin>());
    }
}
