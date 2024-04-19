package com.example.carshop.controller;

import com.example.carshop.dto.GarageCreateCommand;
import com.example.carshop.dto.GarageInfo;
import com.example.carshop.service.GarageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/garage")
@Slf4j
public class GarageController {
    private GarageService garageService;

    @Autowired
    public GarageController(GarageService garageService) {
        this.garageService = garageService;
    }

    @PostMapping
    public ResponseEntity<GarageInfo> save(@RequestBody GarageCreateCommand command) {
        log.info("Http request, POST / /api/garage, body: " + command.toString());
        GarageInfo garageInfo = garageService.saveGarage(command);
        return new ResponseEntity<>(garageInfo, HttpStatus.CREATED);
    }
}
