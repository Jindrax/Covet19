package com.javeriana.web.four.covet19.Veterinarios.Cita.Domain.ValueObjects;

import com.javeriana.web.four.covet19.Shared.Domain.StringValueObject;

public class DiagnosticoCita extends StringValueObject {
    
    private DiagnosticoCita() {}

    public DiagnosticoCita(String diagnostico) {
        this.validate(diagnostico);
        this.value = diagnostico;
    }

    private void validate(String diagnostico) {
    }

}