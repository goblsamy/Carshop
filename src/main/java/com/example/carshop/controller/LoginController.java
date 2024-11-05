package com.example.carshop.controller;

import com.example.carshop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/login")
public class LoginController {

//    private final String correctPassword = "test1234";
//
//    @PostMapping
//    public ResponseEntity<Void> login(HttpServletRequest request) {
//        String username = request.getParameter("username");
//        String password = request.getParameter("password");
//
//        if (correctPassword.equals(password)) {
//            request.getSession().setAttribute("username", username);
//            return ResponseEntity.ok().build();
//        } else
//
//            return ResponseEntity.badRequest().build();
//
//    }

    private UserService userService;

    @Autowired
    public LoginController(UserService userService) {
        this.userService = userService;
    }

//    @PostMapping
//    public ResponseEntity<String> login(HttpServletRequest request) {
//
//        String email = request.getParameter("emailLog");
//        String password = request.getParameter("passwordLog");
//
////        boolean loginSuccess = userService.checkUsernameAndPassword(email, password);
//
////        if (loginSuccess) {
////            HttpSession session = request.getSession();
////            session.setAttribute("loggedInUserEmail", email);
////
////            return ResponseEntity.ok().body("Login successful!");
////        } else {
////            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Incorrect email or password!");
////        }
//
//    }
}
