package com.javeriana.web.four.covet19.Shared.Infrastructure.Security.Controllers;


import com.javeriana.web.four.covet19.Productos.Producto.Application.Exceptions.NotFound;
import com.javeriana.web.four.covet19.Shared.Application.Login;
import com.javeriana.web.four.covet19.Shared.Domain.Security.Auth.AuthResponse;
import com.javeriana.web.four.covet19.Shared.Domain.Security.Auth.Exceptions.IncorrectCredentials;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/login")
public class LoginPostController {

    @Autowired
    private final Login login;

    @Autowired
    private Environment env;

    private final String PASS = "pandillaDeCuatro";

    private final long VALIDITY = 24 * 60 * 60 * 1000;

    public LoginPostController(Login login) {
        this.login = login;
    }

    @PostMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity execute(@RequestBody Request request) {
        try {
            AuthResponse authResponse = login.execute(request.email, request.pass);
            List<GrantedAuthority> grantedAuthorities = AuthorityUtils.commaSeparatedStringToAuthorityList(authResponse.getCredentials().getAuthorities());
            String token = Jwts.builder()
                    .setId(authResponse.getCredentials().getSubject())
                    .setSubject(authResponse.getCredentials().getSubject())
                    .claim("authorities", grantedAuthorities.stream().map(GrantedAuthority::getAuthority)
                            .collect(Collectors.toList()))
                    .setIssuedAt(new Date())
                    .setExpiration(new Date(System.currentTimeMillis() + VALIDITY))
                    .signWith(SignatureAlgorithm.HS512, PASS.getBytes()).compact();
            HashMap<String, Object> response = new HashMap<>();
            response.put("token", token);
            response.put("user", authResponse.getEntity().dataToAuth());
            return ResponseEntity.status(HttpStatus.OK).body(response);
        } catch (IncorrectCredentials ex) {
            ex.printStackTrace();
            return ResponseEntity.status(403).body(null);
        } catch (NotFound ex) {
            ex.printStackTrace();
            return ResponseEntity.status(404).body(null);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(400).body(null);
        }
    }

    static class Request {
        private String email;
        private String pass;

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getPass() {
            return pass;
        }

        public void setPass(String pass) {
            this.pass = pass;
        }
    }
}
