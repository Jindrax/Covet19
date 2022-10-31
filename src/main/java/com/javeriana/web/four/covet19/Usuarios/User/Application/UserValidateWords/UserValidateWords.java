package com.javeriana.web.four.covet19.Usuarios.User.Application.UserValidateWords;

import com.javeriana.web.four.covet19.Usuarios.User.Domain.Exceptions.BadWordsError;
import com.javeriana.web.four.covet19.Usuarios.User.Domain.Ports.ValidateWordService;

public class UserValidateWords {

    private final ValidateWordService service;

    public UserValidateWords(ValidateWordService service) {
        this.service = service;
    }

    public void execute (String word)
    {
        if (service.validate(word))
        {
            throw new BadWordsError("The nickname contains bad words");
        }
    }
}
