package com.javeriana.web.four.covet19.Usuarios.Pedidos.Pedido.Domain.ValueObjects;

import com.javeriana.web.four.covet19.Shared.Domain.BooleanValueObject;

import java.io.Serializable;

public class EnviadoPedido extends BooleanValueObject implements Serializable {
    private EnviadoPedido() {}

    public EnviadoPedido(Boolean enviado) {
        value = enviado;
    }

}