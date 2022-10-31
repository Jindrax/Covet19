package com.javeriana.web.four.covet19.Usuarios.User.Application.UserDomainFinder;

import com.javeriana.web.four.covet19.Usuarios.User.Domain.Exceptions.UserNotExist;
import com.javeriana.web.four.covet19.Usuarios.User.Domain.Ports.UserRepository;
import com.javeriana.web.four.covet19.Usuarios.User.Domain.User;

import java.util.Optional;

public class UserDomainFinder {

    private final UserRepository repository;

    public UserDomainFinder(UserRepository repository) {
        this.repository = repository;
    }

    public Optional<User> execute(String userId) {
        Optional<User> user = repository.find(userId);

        if (user.isEmpty()) {
            throw new UserNotExist("User with id: " + userId + " not exist");
        }

        return user;
    }
}
