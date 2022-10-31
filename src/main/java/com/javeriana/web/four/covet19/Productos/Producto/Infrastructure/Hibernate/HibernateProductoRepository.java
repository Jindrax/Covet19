package com.javeriana.web.four.covet19.Productos.Producto.Infrastructure.Hibernate;

import com.javeriana.web.four.covet19.Productos.Producto.Domain.Ports.ProductoRepository;
import com.javeriana.web.four.covet19.Productos.Producto.Domain.Producto;
import com.javeriana.web.four.covet19.Shared.Domain.Productos.ProductoId;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;
import java.util.Optional;

@Transactional("transactional-manager")
public class HibernateProductoRepository implements ProductoRepository {

    protected final SessionFactory sessionFactory;
    protected final Class<Producto>  aggregateClass;

    public HibernateProductoRepository(@Qualifier("session-factory") SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
        this.aggregateClass = Producto.class;
    }

    @Override
    public void update(Producto producto) {
        this.sessionFactory.getCurrentSession().update(producto);
        this.sessionFactory.getCurrentSession().flush();
        this.sessionFactory.getCurrentSession().clear();
    }

    @Override
    public Optional<Producto> find(String productoId) {
        return sessionFactory.getCurrentSession().byId(aggregateClass).loadOptional(new ProductoId(productoId));
    }

    @Override
    public void save(Producto producto) {
        sessionFactory.getCurrentSession().save(producto);
        sessionFactory.getCurrentSession().flush();
        sessionFactory.getCurrentSession().clear();
    }

    @Override
    public Optional<List<Producto>> all() {
        CriteriaBuilder cb = sessionFactory.getCurrentSession().getCriteriaBuilder();
        CriteriaQuery<Producto> cq = cb.createQuery(Producto.class);
        Root<Producto> root = cq.from(Producto.class);
        CriteriaQuery<Producto> all = cq.select(root);
        TypedQuery<Producto> allQuery = sessionFactory.getCurrentSession().createQuery(all);
        return Optional.ofNullable(allQuery.getResultList());
    }

    @Override
    public Optional<List<Producto>> allLike(String nombreBuscar) {
        Query query = sessionFactory.getCurrentSession().createQuery("FROM Producto as prod WHERE prod.nombreProducto like '%"+nombreBuscar+"%'");
        return Optional.ofNullable(query.list());
    }
}
