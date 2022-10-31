package com.javeriana.web.four.covet19.Shared.Domain.Persona.ValueObjects;

import com.javeriana.web.four.covet19.Shared.Domain.StringValueObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.regex.Pattern;

public class PasswordPersona extends StringValueObject {

    public PasswordPersona() {
    }

    public PasswordPersona(String value) {
        this.validate(value);
        this.value = value;
    }

    private void validate(String value) {
        this.UpperLowerRule(value);
        this.LenghtRule(value);
        this.SymbolsRule(value);
    }

    private void UpperLowerRule(String value) {
        Pattern pattern = Pattern.compile("^(?=.*[a-z])(?=.*[A-Z])");
        boolean match = pattern.matcher(value).find();
        if (!match)
        {
            throw new RuntimeException("The password doesn't have one upper letter and one lower letter at least");
        }
    }

    private void LenghtRule(String value) {
        if (value.length() < 8) {
            throw new RuntimeException("Number of characters invalid");
        }
    }

    private void SymbolsRule(String value) {
        List<String> symbols = new ArrayList<>(){{ add("*"); add("&"); add("="); add("$");}};
        Optional<String> result = symbols.stream().filter(w -> value.contains(w)).findFirst();

        //TODO: Corregir el error de isEmpty
//        if (result.isEmpty()) {
//            throw new RuntimeException("The password doesn't contains any symbol of these: *&=$");
//        }
    }
}
