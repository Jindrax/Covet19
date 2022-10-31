package com.javeriana.web.four.covet19.Shared.Domain;

import java.util.Objects;

public class BooleanValueObject {
    protected Boolean value;

    public Boolean value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BooleanValueObject that = (BooleanValueObject) o;
        return Objects.equals(value, that.value);
    }
}
