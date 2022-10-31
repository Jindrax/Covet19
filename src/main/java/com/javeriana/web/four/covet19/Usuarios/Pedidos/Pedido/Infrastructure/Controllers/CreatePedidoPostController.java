package com.javeriana.web.four.covet19.Usuarios.Pedidos.Pedido.Infrastructure.Controllers;

import com.javeriana.web.four.covet19.Usuarios.Pedidos.Pedido.Application.Create.CreatePedido;
import com.javeriana.web.four.covet19.Usuarios.User.Application.Find.UserFinder;
import com.javeriana.web.four.covet19.Usuarios.User.Domain.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/pedido")
public class CreatePedidoPostController {

    CreatePedido createPedido;
    UserFinder userFinder;

    public CreatePedidoPostController(CreatePedido createPedido, UserFinder userFinder) {
        this.createPedido = createPedido;
        this.userFinder = userFinder;
    }

    @PostMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity execute(@RequestBody Request request){
        try {
            User user = userFinder.execute(request.id);
            createPedido.execute(user);
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(null);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e);
            return ResponseEntity.status(400).body(e.getMessage());
        }
    }


    static class Request{
        private String id;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }
    }
}
