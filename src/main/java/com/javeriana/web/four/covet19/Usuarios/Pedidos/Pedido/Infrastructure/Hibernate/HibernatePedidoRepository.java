package com.javeriana.web.four.covet19.Usuarios.Pedidos.Pedido.Infrastructure.Hibernate;

import com.javeriana.web.four.covet19.Shared.Domain.Pedido.IdPedido;
import com.javeriana.web.four.covet19.Usuarios.Pedidos.Pedido.Domain.Pedido;
import com.javeriana.web.four.covet19.Usuarios.Pedidos.Pedido.Domain.Ports.PedidoRepository;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional("transactional-manager")
public class HibernatePedidoRepository implements PedidoRepository {
    protected final SessionFactory sessionFactory;
    protected final Class<Pedido>  aggregateClass;

    public HibernatePedidoRepository(@Qualifier("session-factory") SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
        this.aggregateClass = Pedido.class;
    }

    @Override
    public void update(Pedido pedido) {
        this.sessionFactory.getCurrentSession().update(pedido);
    }

    @Override
    public Optional<Pedido> find(String idPedido) {
        IdPedido id = new IdPedido(idPedido);
        return Optional.ofNullable(sessionFactory.getCurrentSession().byId(aggregateClass).load(id));
    }

    @Override
    public void save(Pedido pedido) {
        sessionFactory.getCurrentSession().save(pedido);
        sessionFactory.getCurrentSession().flush();
        sessionFactory.getCurrentSession().clear();
    }

    @Override
    public Optional<List<Pedido>> all() {
        Query query = sessionFactory.getCurrentSession().createQuery("From Pedido");
        return Optional.ofNullable(query.list());
    }
}
