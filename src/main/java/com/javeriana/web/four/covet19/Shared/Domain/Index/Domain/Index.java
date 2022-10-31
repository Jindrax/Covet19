package com.javeriana.web.four.covet19.Shared.Domain.Index.Domain;

import com.javeriana.web.four.covet19.Shared.Domain.Index.Domain.ValueObjects.RefererenceValueObject;
import com.javeriana.web.four.covet19.Shared.Domain.Index.Domain.ValueObjects.RolValueObject;
import com.javeriana.web.four.covet19.Shared.Domain.Persona.ValueObjects.CorreoPersona;

public class Index {
    private CorreoPersona correoPersona;
    private RefererenceValueObject refererenceValueObject;
    private RolValueObject rolValueObject;

    public Index() {
    }

    public Index(CorreoPersona correoPersona, RefererenceValueObject refererenceValueObject, RolValueObject rolValueObject) {
        this.correoPersona = correoPersona;
        this.refererenceValueObject = refererenceValueObject;
        this.rolValueObject = rolValueObject;
    }

    public static Index create(String email, String referenceId, String rol) {
        return new Index(new CorreoPersona(email), new RefererenceValueObject(referenceId), new RolValueObject(rol));
    }

    public String getCorreoPersona() {
        return correoPersona.value();
    }

    public String getRefererenceValueObject() {
        return refererenceValueObject.value();
    }

    public String getRolValueObject() {
        return rolValueObject.value();
    }
}
