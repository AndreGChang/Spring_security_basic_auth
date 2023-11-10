package com.example.spring_security.controller;

import com.example.spring_security.entity.User;
import com.example.spring_security.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/livre")
    public String rotaLivre(){
        return "<h1>ROTA LIVRE</h1>";
    }

    @PostMapping("/sdçafdsç")
    public String rotelivreteste(){
        return "<h1>ROTA LIVRE TAMBEM</h1>";
    }

    @GetMapping("/userAuth")
    @PreAuthorize("hasRole('ROLE_USER')")
    public String rotaUser(){
        return "<h1>ROTA DE USUSRIO AUTENTICADO</h1>";
    }

    @GetMapping("/adminAuth")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String rotaAdmin(){
        return "<h1>ROTA DE USUSRIO AUTENTICADO</h1>";
    }


    @PostMapping("/register")
    public ResponseEntity<HttpStatus> cadastrarUser(@RequestBody User user){
        try{
            userService.registrar(user);
            return ResponseEntity.ok(HttpStatus.OK);
        }catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


}
