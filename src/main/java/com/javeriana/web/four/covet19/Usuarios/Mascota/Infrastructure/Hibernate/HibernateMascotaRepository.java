package com.javeriana.web.four.covet19.Usuarios.Mascota.Infrastructure.Hibernate;


import com.javeriana.web.four.covet19.Shared.Domain.Mascota.IdMascota;
import com.javeriana.web.four.covet19.Usuarios.Mascota.Domain.Mascota;
import com.javeriana.web.four.covet19.Usuarios.Mascota.Domain.Ports.MascotaRepository;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional("transactional-manager")
public class HibernateMascotaRepository implements MascotaRepository {

    protected final SessionFactory sessionFactory;
    protected final Class<Mascota>  aggregateClass;

    public HibernateMascotaRepository(@Qualifier("session-factory") SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
        this.aggregateClass = Mascota.class;
    }


    @Override
    public void update(Mascota mascota) {
        this.sessionFactory.getCurrentSession().update(mascota);
    }

    @Override
    public Optional<Mascota> find(String idMascota) {
        IdMascota id = new IdMascota(idMascota);
        return Optional.ofNullable(sessionFactory.getCurrentSession().byId(aggregateClass).load(id));
    }

    @Override
    public void save(Mascota mascota) {
        sessionFactory.getCurrentSession().save(mascota);
        sessionFactory.getCurrentSession().flush();
        sessionFactory.getCurrentSession().clear();
    }

    @Override
    public Optional<List<Mascota>> all() {
        Query query = sessionFactory.getCurrentSession().createQuery("From Mascota");
        return Optional.ofNullable(query.list());
    }
}
