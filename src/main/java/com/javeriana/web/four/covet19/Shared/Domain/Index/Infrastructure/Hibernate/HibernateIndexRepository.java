package com.javeriana.web.four.covet19.Shared.Domain.Index.Infrastructure.Hibernate;

import com.javeriana.web.four.covet19.Shared.Domain.Index.Domain.Index;
import com.javeriana.web.four.covet19.Shared.Domain.Index.Domain.Ports.IndexRepository;
import com.javeriana.web.four.covet19.Shared.Domain.Persona.ValueObjects.CorreoPersona;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Transactional("transactional-manager")
public class HibernateIndexRepository implements IndexRepository {

    protected final SessionFactory sessionFactory;
    protected final Class<Index>  aggregateClass;

    public HibernateIndexRepository(@Qualifier("session-factory") SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
        this.aggregateClass = Index.class;
    }

    @Override
    public Optional<Index> find(String email) {
        return sessionFactory.getCurrentSession().byId(aggregateClass).loadOptional(new CorreoPersona(email));
    }

    @Override
    public void save(Index index) {
        sessionFactory.getCurrentSession().save(index);
        sessionFactory.getCurrentSession().flush();
        sessionFactory.getCurrentSession().clear();
    }
}
