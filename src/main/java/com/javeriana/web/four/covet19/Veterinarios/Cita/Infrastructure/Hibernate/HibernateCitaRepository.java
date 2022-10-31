package com.javeriana.web.four.covet19.Veterinarios.Cita.Infrastructure.Hibernate;


import com.javeriana.web.four.covet19.Shared.Domain.Citas.IdCita;
import com.javeriana.web.four.covet19.Veterinarios.Cita.Domain.Cita;
import com.javeriana.web.four.covet19.Veterinarios.Cita.Domain.Ports.CitaRepository;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional("transactional-manager")
public class HibernateCitaRepository implements CitaRepository {
    protected final SessionFactory sessionFactory;
    protected final Class<Cita> aggregateClass;

    public HibernateCitaRepository(@Qualifier("session-factory") SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
        this.aggregateClass = Cita.class;
    }

    @Override
    public void update(Cita cita) {
        this.sessionFactory.getCurrentSession().update(cita);
    }

    @Override
    public Optional<Cita> find(String idCita) {
        IdCita id = new IdCita(idCita);
        return Optional.ofNullable(sessionFactory.getCurrentSession().byId(aggregateClass).load(id));
    }

    @Override
    public void save(Cita cita) {
        sessionFactory.getCurrentSession().save(cita);
        sessionFactory.getCurrentSession().flush();
        sessionFactory.getCurrentSession().clear();
    }

    @Override
    public Optional<List<Cita>> all() {
        Query query = sessionFactory.getCurrentSession().createQuery("From Cita");
        return Optional.ofNullable(query.list());
    }
    @Override
    public void delete(Cita cita){
        this.sessionFactory.getCurrentSession().delete(cita);
    }
}