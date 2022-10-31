package com.javeriana.web.four.covet19.Veterinarios.Veterinario.Infrastructure.Hibernate;

import com.javeriana.web.four.covet19.Shared.Domain.Persona.ValueObjects.IdPersona;
import com.javeriana.web.four.covet19.Veterinarios.Veterinario.Domain.Ports.VeterinarioRepository;
import com.javeriana.web.four.covet19.Veterinarios.Veterinario.Domain.Veterinario;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional("transactional-manager")
public class HibernateVeterinarioRepository implements VeterinarioRepository {
    protected final SessionFactory sessionFactory;
    protected final Class<Veterinario>  aggregateClass;

    public HibernateVeterinarioRepository(@Qualifier("session-factory") SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
        this.aggregateClass = Veterinario.class;
    }

    @Override
    public void update(Veterinario veterinario) {
        this.sessionFactory.getCurrentSession().update(veterinario);
    }

    @Override
    public Optional<Veterinario> find(String idVeterinario) {
        IdPersona id = new IdPersona(idVeterinario);
        return Optional.ofNullable(sessionFactory.getCurrentSession().byId(aggregateClass).load(id));
    }

    @Override
    public void save(Veterinario veterinario) {
        sessionFactory.getCurrentSession().save(veterinario);
        sessionFactory.getCurrentSession().flush();
        sessionFactory.getCurrentSession().clear();
    }

    @Override
    public Optional<List<Veterinario>> all() {
        Query query = sessionFactory.getCurrentSession().createQuery("From Veterinario");
        return Optional.ofNullable(query.list());
    }
}
