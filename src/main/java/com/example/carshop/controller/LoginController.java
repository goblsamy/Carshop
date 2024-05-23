package com.example.carshop.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/api/login")
public class LoginController {

    @PostMapping
    public ResponseEntity<Void> login(HttpServletRequest request) {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        return ResponseEntity.ok().build();
    }
}
