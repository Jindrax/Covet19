package com.javeriana.web.four.covet19.Admins.Admin.Infrastructure.Controllers;

import com.javeriana.web.four.covet19.Admins.Admin.Application.All.AllAdmins;
import com.javeriana.web.four.covet19.Admins.Admin.Domain.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/admins")
public class AllAdminsGetController {

    @Autowired
    private AllAdmins allAdmins;

    @GetMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<HashMap<String, Object>>> execute() {
        try {
            List<HashMap<String, Object>> productos = allAdmins.execute().stream().map(Admin::data).collect(Collectors.toList());
            return ResponseEntity.ok(productos);
        } catch (Exception e) {
            System.out.println(e);
            return ResponseEntity.status(400).body(null);
        }
    }
}
