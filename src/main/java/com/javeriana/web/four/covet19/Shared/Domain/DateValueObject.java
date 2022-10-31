package com.javeriana.web.four.covet19.Shared.Domain;

import java.util.Date;
import java.util.Objects;

public class DateValueObject {

    protected Date value;

    public Date value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DateValueObject that = (DateValueObject) o;
        return Objects.equals(value, that.value);
    }
}
