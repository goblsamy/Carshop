package com.example.carshop.controller;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/profile")
public class ProfileController {

    @GetMapping
    public ResponseEntity<String> getProfile(HttpServletRequest request) {
        if (request.getSession().getAttribute("username") == null) {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
        String username = (String) request.getSession().getAttribute("username");
        return new ResponseEntity<>(username, HttpStatus.OK);
    }
}
