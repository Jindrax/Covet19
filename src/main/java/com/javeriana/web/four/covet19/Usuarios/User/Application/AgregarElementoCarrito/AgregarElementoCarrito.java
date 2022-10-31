package com.javeriana.web.four.covet19.Usuarios.User.Application.AgregarElementoCarrito;

import com.javeriana.web.four.covet19.Productos.Producto.Application.Find.FindProducto;
import com.javeriana.web.four.covet19.Productos.Producto.Domain.Producto;
import com.javeriana.web.four.covet19.Usuarios.User.Domain.Exceptions.UserNotExist;
import com.javeriana.web.four.covet19.Usuarios.User.Domain.Ports.UserRepository;
import com.javeriana.web.four.covet19.Usuarios.User.Domain.User;
import com.javeriana.web.four.covet19.Usuarios.User.Domain.ValueObjects.ElementoCarritoUsuario;

import java.util.HashMap;
import java.util.Optional;

public class AgregarElementoCarrito {

    private final UserRepository repository;
    private final FindProducto findProducto;

    public AgregarElementoCarrito(UserRepository repository, FindProducto findProducto) {
        this.repository = repository;
        this.findProducto = findProducto;
    }

    public void execute(String idUsuario, String idProducto,long cantidad){
        Optional<User> usuario = repository.find(idUsuario);
        if (usuario.isEmpty())
        {
            throw new UserNotExist(idUsuario);
        }
        Optional<Producto> producto = findProducto.execute(idProducto);
        if (producto.isEmpty())
        {
            throw new RuntimeException("el producto con identificador "+ idProducto + " no es existe");
        }
        User finalUser = usuario.get();
        Producto elemento = producto.get();
        if (!elemento.disponibilidad( (int) cantidad)) {
            throw new RuntimeException("no hay unidades suficientes disponibles");
        }
        HashMap<String, Object> infoP = elemento.data();
        ElementoCarritoUsuario element = new ElementoCarritoUsuario(cantidad, String.valueOf(infoP.get("id")),String.valueOf(infoP.get("nombre")),
                                                                    String.valueOf(infoP.get("descripcion")), String.valueOf(infoP.get("marca")), (double) infoP.get("precio"));
        finalUser.addElementoCarrito(element);
        repository.update( finalUser.getUserId().toString(),finalUser);
    }
}
