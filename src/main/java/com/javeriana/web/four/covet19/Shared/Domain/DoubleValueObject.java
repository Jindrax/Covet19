package com.javeriana.web.four.covet19.Shared.Domain;

import java.util.Objects;

public class DoubleValueObject {

    protected Double value;

    public Double value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DoubleValueObject that = (DoubleValueObject) o;
        return Objects.equals(value, that.value);
    }
}
