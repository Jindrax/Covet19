package com.javeriana.web.four.covet19.Admins.Admin.Domain.Ports;

import com.javeriana.web.four.covet19.Admins.Admin.Domain.Admin;

import java.util.List;
import java.util.Optional;

public interface AdminRepository {
    void update(Admin admin);

    Optional<Admin> find(String adminId);

    void save(Admin admin);

    Optional<List<Admin>> all();
}
