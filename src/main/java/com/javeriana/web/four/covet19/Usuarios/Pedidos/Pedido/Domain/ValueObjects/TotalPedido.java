package com.javeriana.web.four.covet19.Usuarios.Pedidos.Pedido.Domain.ValueObjects;

import com.javeriana.web.four.covet19.Shared.Domain.DoubleValueObject;

import java.io.Serializable;

public class TotalPedido extends DoubleValueObject implements Serializable {

    public TotalPedido() {
    }

    public TotalPedido(double value) {
        this.value = value;
    }
}
