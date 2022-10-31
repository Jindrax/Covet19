package com.javeriana.web.four.covet19.Admins.Admin.Infrastructure.Hibernate;

import com.javeriana.web.four.covet19.Admins.Admin.Domain.Admin;
import com.javeriana.web.four.covet19.Admins.Admin.Domain.Ports.AdminRepository;
import com.javeriana.web.four.covet19.Shared.Domain.Persona.ValueObjects.IdPersona;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;
import java.util.Optional;

@Transactional("transactional-manager")
public class HibernateAdminRepository implements AdminRepository {

    protected final SessionFactory sessionFactory;
    protected final Class<Admin> aggregateClass;

    public HibernateAdminRepository(@Qualifier("session-factory") SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
        this.aggregateClass = Admin.class;
    }

    @Override
    public void update(Admin admin) {
        this.sessionFactory.getCurrentSession().update(admin);
        this.sessionFactory.getCurrentSession().flush();
        this.sessionFactory.getCurrentSession().clear();
    }

    @Override
    public Optional<Admin> find(String adminId) {
        return sessionFactory.getCurrentSession().byId(aggregateClass).loadOptional(new IdPersona(adminId));
    }

    @Override
    public void save(Admin admin) {
        sessionFactory.getCurrentSession().save(admin);
        sessionFactory.getCurrentSession().flush();
        sessionFactory.getCurrentSession().clear();
    }

    @Override
    public Optional<List<Admin>> all() {
        CriteriaBuilder cb = sessionFactory.getCurrentSession().getCriteriaBuilder();
        CriteriaQuery<Admin> cq = cb.createQuery(Admin.class);
        Root<Admin> root = cq.from(Admin.class);
        CriteriaQuery<Admin> all = cq.select(root);
        TypedQuery<Admin> allQuery = sessionFactory.getCurrentSession().createQuery(all);
        return Optional.ofNullable(allQuery.getResultList());
    }
}
