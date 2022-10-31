package com.javeriana.web.four.covet19.Usuarios.User.Domain.Ports;

import com.javeriana.web.four.covet19.Usuarios.User.Domain.User;

import java.util.Optional;

public interface UserRepository {

    void save(User user);

    Optional<User> find(String userId);

    void update(String userId, User user);
}