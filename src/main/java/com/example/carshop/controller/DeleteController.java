package com.example.carshop.controller;


import com.example.carshop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/api/delete")
public class DeleteController {

    private UserService userService;

    @Autowired
    public DeleteController(UserService userService) {
        this.userService = userService;
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteUser(HttpServletRequest request) {
        HttpSession session = request.getSession();
        String loggedInUserEmail = (String) session.getAttribute("loggedInUserEmail");
        if (loggedInUserEmail == null) {
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }
        userService.delete(loggedInUserEmail);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
