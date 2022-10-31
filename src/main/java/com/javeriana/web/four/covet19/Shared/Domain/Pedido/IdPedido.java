package com.javeriana.web.four.covet19.Shared.Domain.Pedido;

import com.javeriana.web.four.covet19.Shared.Domain.CustomUUID;

import java.io.Serializable;

public class IdPedido extends CustomUUID implements Serializable {

    private IdPedido() {
        super("");
    }

    public IdPedido(String value) {
        super(value);
    }
}
