package com.javeriana.web.four.covet19.Veterinarios.Cita.Application.AgregarDiagnostico;

import com.javeriana.web.four.covet19.Shared.Domain.Bus.Event.DomainEventSubscriber;
import com.javeriana.web.four.covet19.Shared.Domain.Citas.CitaAgregarDiagnosticoDomainEvent;
import com.javeriana.web.four.covet19.Shared.Domain.Citas.CitaCreatedDomainEvent;
import com.javeriana.web.four.covet19.Usuarios.Mascota.Application.ModificarCitaDiagnostico.MascotaModificarCitaDiagnostico;
import com.javeriana.web.four.covet19.Usuarios.Mascota.Domain.Mascota;
import com.javeriana.web.four.covet19.Usuarios.User.Domain.User;
import com.javeriana.web.four.covet19.Veterinarios.Veterinario.Application.ModificarCitaDiagnostico.VeterinarioModificarCitaDiagnostico;
import com.javeriana.web.four.covet19.Veterinarios.Veterinario.Domain.Veterinario;
import org.springframework.context.event.EventListener;

import java.io.IOException;

@DomainEventSubscriber({CitaAgregarDiagnosticoDomainEvent.class})
public class NotifyOnCitaAgregarDiagnostico {

    private final VeterinarioModificarCitaDiagnostico modificarCitaVeterinario;
    private final MascotaModificarCitaDiagnostico modificarCitaMascota;

    public NotifyOnCitaAgregarDiagnostico(VeterinarioModificarCitaDiagnostico modificarCitaVeterinario,
                                          MascotaModificarCitaDiagnostico modificarCitaMascota) {
        this.modificarCitaVeterinario = modificarCitaVeterinario;
        this.modificarCitaMascota = modificarCitaMascota;
    }

    @EventListener
    public void on(CitaAgregarDiagnosticoDomainEvent event) {
        //Evento para actualizar Citas del Veterinario
        modificarCitaVeterinario.execute(event.getVeterinarioId(), event.aggregateId(), event.getDiagnostico());

        //Evento para actualizar Citas de la mascota
        modificarCitaMascota.execute(event.getMascotaId(), event.aggregateId(), event.getDiagnostico());

        System.out.println("Llego el evento CitaAgregarDiagnosticoDomainEvent: " + event.aggregateId());
    }

}
