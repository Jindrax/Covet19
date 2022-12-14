package com.javeriana.web.four.covet19.Shared.Domain;

import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

public class CustomUUID implements Serializable {

    private final String value;
    

    public CustomUUID(String value) {
//        this.validate(value);
        this.value = value;
    }

    private void validate(String value) {
        this.validateUUIDFormatRule(value);
    }

    public String value() {
        return value;
    }

    private void validateUUIDFormatRule(String value)
    {
        try {
            UUID.fromString(value);
        }
        catch (Exception ex)
        {
            throw new UUIDNotValid("The UUID has not valid format");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CustomUUID that = (CustomUUID) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}