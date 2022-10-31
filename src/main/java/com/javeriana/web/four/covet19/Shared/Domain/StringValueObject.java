package com.javeriana.web.four.covet19.Shared.Domain;

import java.io.Serializable;
import java.util.Objects;

public class StringValueObject implements Serializable {
    protected String value;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StringValueObject that = (StringValueObject) o;
        return Objects.equals(value, that.value);
    }

    public String value() {
        return value;
    }
}
