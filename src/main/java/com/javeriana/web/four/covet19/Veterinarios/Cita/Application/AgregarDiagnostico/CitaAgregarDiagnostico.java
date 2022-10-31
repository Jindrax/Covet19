package com.javeriana.web.four.covet19.Veterinarios.Cita.Application.AgregarDiagnostico;

import com.javeriana.web.four.covet19.Shared.Domain.Bus.Event.EventBus;
import com.javeriana.web.four.covet19.Usuarios.Mascota.Application.ModificarCitaDiagnostico.MascotaModificarCitaDiagnostico;
import com.javeriana.web.four.covet19.Veterinarios.Cita.Domain.Cita;
import com.javeriana.web.four.covet19.Veterinarios.Cita.Domain.Exceptions.CitaNoExiste;
import com.javeriana.web.four.covet19.Veterinarios.Cita.Domain.Ports.CitaRepository;
import com.javeriana.web.four.covet19.Veterinarios.Cita.Domain.ValueObjects.DiagnosticoCita;
import com.javeriana.web.four.covet19.Veterinarios.Veterinario.Application.ModificarCitaDiagnostico.VeterinarioModificarCitaDiagnostico;

import java.util.Optional;

public class CitaAgregarDiagnostico {

    private final CitaRepository repository;
    private final EventBus eventBus;

    public CitaAgregarDiagnostico(CitaRepository repository,
                                  EventBus eventBus
    ) {
        this.repository = repository;
        this.eventBus = eventBus;
    }

    public void execute(String idCita, String diagnostico)
    {
        Optional<Cita> cita = repository.find(idCita);
        if (cita.isEmpty())
        {
            throw new CitaNoExiste(idCita);
        }
        Cita finalCita = cita.get();
        finalCita.agregarDiagnostico(new DiagnosticoCita(diagnostico));

        repository.update(finalCita);

        finalCita.notifyAgregarDiagnostico();

        eventBus.publish(finalCita.pullDomainEvents());
    }

}
