package com.javeriana.web.four.covet19.Usuarios.Pedidos.Pedido.Domain.ValueObjects;

import com.javeriana.web.four.covet19.Shared.Domain.BooleanValueObject;

import java.io.Serializable;


public class FinalizadoPedido extends BooleanValueObject implements Serializable {
    private FinalizadoPedido() {}

    public FinalizadoPedido(Boolean finalizado) {
        value = finalizado;
    }

}
