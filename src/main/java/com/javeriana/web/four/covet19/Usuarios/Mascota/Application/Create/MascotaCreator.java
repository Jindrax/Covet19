package com.javeriana.web.four.covet19.Usuarios.Mascota.Application.Create;

import com.javeriana.web.four.covet19.Shared.Domain.Mascota.IdMascota;
import com.javeriana.web.four.covet19.Shared.Domain.Persona.ValueObjects.IdPersona;
import com.javeriana.web.four.covet19.Usuarios.Mascota.Domain.Mascota;
import com.javeriana.web.four.covet19.Usuarios.Mascota.Domain.ValueObjects.*;
import com.javeriana.web.four.covet19.Usuarios.Mascota.Infrastructure.Hibernate.HibernateMascotaRepository;
import com.javeriana.web.four.covet19.Usuarios.User.Application.AgregarElementoCarrito.AgregarElementoCarrito;
import com.javeriana.web.four.covet19.Usuarios.User.Application.AgregarMascota.AgregarMascota;

public class MascotaCreator {

    private HibernateMascotaRepository repository;
    private AgregarMascota agregarMascota;

    public MascotaCreator(HibernateMascotaRepository repository, AgregarMascota agregarMascota){
        this.repository = repository;
        this.agregarMascota  = agregarMascota;
    }

    public void execute(String idMascota,
                        String nombreMascota,
                        int edadMascota,
                        double pesoMascota,
                        String tipoMascota,
                        String razaMascota,
                        String idUsuario)
    {
        Mascota mascota = Mascota.create(
                new IdMascota(idMascota),
                new EdadMascota(edadMascota),
                new NombreMascota(nombreMascota),
                new PesoMascota(pesoMascota),
                new TipoMascota(tipoMascota),
                new RazaMascota(razaMascota),
                new IdPersona(idUsuario)
        );
        repository.save(mascota);
        agregarMascota.execute(idUsuario,mascota);
    }
    public MascotaCreator(){
    }
}
