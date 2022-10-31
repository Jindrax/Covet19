package com.javeriana.web.four.covet19.Usuarios.Pedidos.Pedido.Domain;

import com.javeriana.web.four.covet19.Shared.Domain.Aggregate.AggregateRoot;
import com.javeriana.web.four.covet19.Shared.Domain.Mail.MailIssuedDomainEvent;
import com.javeriana.web.four.covet19.Shared.Domain.Pedido.IdPedido;
import com.javeriana.web.four.covet19.Shared.Domain.Persona.ValueObjects.IdPersona;
import com.javeriana.web.four.covet19.Shared.Domain.Productos.ProductoConsumedDomainEvent;
import com.javeriana.web.four.covet19.Usuarios.Pedidos.Pedido.Domain.ValueObjects.*;

import java.io.Serializable;
import java.util.*;
import java.util.stream.Collectors;

public class Pedido extends AggregateRoot implements Serializable {
    private IdPedido idPedido;
    private FinalizadoPedido finalizadoPedido;
    private EnviadoPedido enviadoPedido;
    private FechaFinalizadoPedido fechaFinalizadoPedido;
    private FechaEnviadoPedido fechaEnviadoPedido;
    private IdPersona idUsuario;
    private Optional<List<CompraPedidoDetail>> compraPedidos;
    private TotalPedido totalPedido;


    public Pedido(
            IdPedido idPedido,
            FinalizadoPedido finalizadoPedido,
            EnviadoPedido enviadoPedido,
            FechaFinalizadoPedido fechaFinalizadoPedido,
            FechaEnviadoPedido fechaEnviadoPedido,
            IdPersona idUsuario,
            List<CompraPedidoDetail> compraPedidos,
            TotalPedido totalPedido) {
        this.idPedido = idPedido;
        this.finalizadoPedido = finalizadoPedido;
        this.enviadoPedido = enviadoPedido;
        this.fechaEnviadoPedido = fechaEnviadoPedido;
        this.fechaFinalizadoPedido = fechaFinalizadoPedido;
        this.idUsuario = idUsuario;
        this.compraPedidos = Optional.ofNullable(compraPedidos);
        this.totalPedido = totalPedido;
    }

    public static Pedido create(String idUsuario) {
        UUID uid = UUID.randomUUID();
        IdPedido idPedido = new IdPedido(uid.toString());
        Date indefinido = new Date();
        indefinido.setTime(1L);
        return new Pedido(idPedido, new FinalizadoPedido(false),
                new EnviadoPedido(false),
                new FechaFinalizadoPedido(indefinido),
                new FechaEnviadoPedido(indefinido),
                new IdPersona(idUsuario),
                new ArrayList<CompraPedidoDetail>(),
                new TotalPedido(0));
    }

    public void consumirProducto(CompraPedidoDetail producto) {
        if (compraPedidos.isPresent()) {
            this.compraPedidos.get().add(producto);
            this.totalPedido = new TotalPedido(this.totalPedido.value() + producto.getCantidad() * producto.getPrecio());
            this.record(new ProductoConsumedDomainEvent(producto.getId(), producto.getCantidad()));
        }
    }

    public Optional<List<HashMap<String, Object>>> getCompraPedidos() {
        Optional<List<HashMap<String, Object>>> response = Optional.empty();
        if (this.compraPedidos.isPresent()) {
            response = Optional.of(this.compraPedidos.get().stream().map(CompraPedidoDetail::data).collect(Collectors.toList()));
        }
        return response;
    }

    public HashMap<String, Object> data() {
        return new HashMap<>() {{
            put("idPedido", idPedido.value());
            put("enviadoPedido", enviadoPedido.value());
            put("fechaEnviadoPedido", fechaEnviadoPedido.value());
            put("finalizadoPedido", finalizadoPedido.value());
            put("fechaFinalizadoPedido", fechaFinalizadoPedido.value());
            put("idUsuario", idUsuario.value());
            put("compraPedido", getCompraPedidos());
        }};
    }

    public void finalizarPedido() {
        Date fecha = new Date();
        this.finalizadoPedido = new FinalizadoPedido(true);
        this.fechaFinalizadoPedido = new FechaFinalizadoPedido(fecha);

    }

    public void enviarPedido() {
        Date fecha = new Date();
        this.enviadoPedido = new EnviadoPedido(true);
        this.fechaEnviadoPedido = new FechaEnviadoPedido(fecha);
    }

    public Boolean getfinalizadoPedido() {
        return this.finalizadoPedido.value();
    }

    public Boolean getEnviadoPedido() {
        return this.enviadoPedido.value();
    }

    private Pedido() {
    }

    public String getIdUsiario() {
        return this.idUsuario.value();
    }

    private String prepareToMail() {
        StringBuilder content = new StringBuilder().append("Su pedido consiste de: \n");
        compraPedidos.ifPresent(pedidoDetails -> pedidoDetails.forEach(compraPedidoDetails -> content
                .append("\t")
                .append(compraPedidoDetails.getNombre())
                .append(" X ")
                .append(compraPedidoDetails.getCantidad())
                .append(" = ")
                .append(compraPedidoDetails.getCantidad() * compraPedidoDetails.getPrecio())
                .append("\n")
        ));
        content.append("Para un total de ").append(totalPedido.value());
        return content.toString();
    }

    public void sendTo(String email) {
        this.record(new MailIssuedDomainEvent(idPedido.value(), email, "Pedido " + idPedido.value() + " creado exitosamente", prepareToMail()));
    }
}
