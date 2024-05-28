package com.example.carshop.controller;

import com.example.carshop.dto.GarageCreateCommand;
import com.example.carshop.dto.GarageInfo;
import com.example.carshop.dto.GarageUpdateCommand;
import com.example.carshop.service.GarageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

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
    public ResponseEntity<GarageInfo> save(@Valid @RequestBody GarageCreateCommand command) {
        log.info("Http request, POST / /api/garage, body: " + command.toString());
        GarageInfo garageInfo = garageService.saveGarage(command);
        return new ResponseEntity<>(garageInfo, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<GarageInfo>> findAll() {
        log.info("Http request, GET / /api/garage");
        List<GarageInfo> garageInfos = garageService.listGarages();
        return new ResponseEntity<>(garageInfos, HttpStatus.OK);
    }

    @GetMapping("/{garageId}")
    public ResponseEntity<GarageInfo> findById(@PathVariable("garageId") Integer id) {
        log.info("Http request, GET / /api/garage/{garageId} with variable: " + id);
        GarageInfo garageInfo = garageService.getById(id);
        return new ResponseEntity<>(garageInfo, HttpStatus.OK);

    }

    @DeleteMapping("/{garageId}")
    public ResponseEntity<GarageInfo> delete(@PathVariable("garageId") Integer id) {
        log.info("Http request, DELETE / /api/garage/{id} with variable: " + id);
        garageService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/{garageId}")
    public ResponseEntity<GarageInfo> update(@PathVariable("garageId") Integer id,
                                             @Valid @RequestBody GarageUpdateCommand command) {
        log.info("Http request, PUT / /api/garage/{id} body " + command.toString() + "with variable: " + id);
        GarageInfo garageInfo = garageService.update(id, command);
        return new ResponseEntity<>(garageInfo, HttpStatus.OK);
    }
}
