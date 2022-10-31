package com.javeriana.web.four.covet19.Veterinarios.Cita.Application.Update;

import com.javeriana.web.four.covet19.Usuarios.Mascota.Application.ModificarCitaDiagnostico.MascotaModificarCitaDiagnostico;
import com.javeriana.web.four.covet19.Usuarios.Mascota.Application.ModificarFechaCita.MascotaModificarFechaCita;
import com.javeriana.web.four.covet19.Veterinarios.Cita.Domain.Cita;
import com.javeriana.web.four.covet19.Veterinarios.Cita.Domain.Exceptions.CitaNotExist;
import com.javeriana.web.four.covet19.Veterinarios.Cita.Domain.Ports.CitaRepository;
import com.javeriana.web.four.covet19.Veterinarios.Cita.Domain.ValueObjects.DiagnosticoCita;
import com.javeriana.web.four.covet19.Veterinarios.Cita.Domain.ValueObjects.FechaCita;
import com.javeriana.web.four.covet19.Veterinarios.Veterinario.Application.ModificarCitaDiagnostico.VeterinarioModificarCitaDiagnostico;
import com.javeriana.web.four.covet19.Veterinarios.Veterinario.Application.VeterinarioModificarFechaCita.VeterinarioModificarFechaCita;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;

public class CitaUpdate {

    private CitaRepository repository;
    private MascotaModificarCitaDiagnostico diagnosticoMascota;
    private VeterinarioModificarCitaDiagnostico diagnosticoVeterinario;
    private MascotaModificarFechaCita fechaCitaMascota;
    private VeterinarioModificarFechaCita fechaCitaVeterinario;

    public CitaUpdate(CitaRepository repository, MascotaModificarCitaDiagnostico diagnosticoMascota, VeterinarioModificarCitaDiagnostico diagnosticoVeterinario, MascotaModificarFechaCita fechaCitaMascota, VeterinarioModificarFechaCita fechaCitaVeterinario ){
        this.repository = repository;
        this.diagnosticoMascota = diagnosticoMascota;
        this.diagnosticoVeterinario = diagnosticoVeterinario;
        this.fechaCitaMascota = fechaCitaMascota;
        this.fechaCitaVeterinario = fechaCitaVeterinario;
    }

    public void execute(
            String idCita,
            String diagnostico,
            String fechaCita
    ){
        Optional<Cita> cita = repository.find(idCita);
         if (cita.isEmpty()){
             throw new CitaNotExist("la cita " + idCita + "not existe");
         }
         Cita citaTemp = cita.get();
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date fecha = formato.parse(fechaCita);
            fechaCitaMascota.execute(citaTemp.getIdMascota(), idCita,fechaCita);
            diagnosticoVeterinario.execute(citaTemp.getIdVeterinario(), idCita, diagnostico);
            diagnosticoMascota.execute(citaTemp.getIdMascota(), idCita, diagnostico);
            fechaCitaVeterinario.execute(citaTemp.getIdVeterinario(),idCita, fechaCita);
            citaTemp.update(new DiagnosticoCita(diagnostico),
                        new FechaCita(fecha));
            repository.update(citaTemp);
        } catch (ParseException e) {
            e.printStackTrace();
            throw new RuntimeException(String.valueOf(e.getStackTrace()));
        }
    }

}
