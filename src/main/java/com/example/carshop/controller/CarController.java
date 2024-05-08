package com.example.carshop.controller;

import com.example.carshop.domain.CarType;
import com.example.carshop.dto.CarInfo;
import com.example.carshop.dto.CarCreateCommand;
import com.example.carshop.service.CarService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/car")
@Slf4j
public class CarController {

    private CarService carService;

    @Autowired
    public CarController(CarService carService) {
        this.carService = carService;
    }

    @PostMapping
    public ResponseEntity<CarInfo> save(@Valid @RequestBody CarCreateCommand command) {
        log.info("Http request, POST / /api/car, with command: " + command);
        CarInfo carInfo = carService.saveCar(command);
        return new ResponseEntity<>(carInfo, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<CarInfo>> findAll() {
        log.info("HTTP request, GET / /api/car");
        List<CarInfo> carInfoList = carService.listCars();
        return new ResponseEntity<>(carInfoList, HttpStatus.OK);
    }

    @GetMapping("/{carId}")
    public ResponseEntity<CarInfo> findById(@PathVariable("carId") Integer id) {
        log.info("HTTP request, GET / /api/car/{carId} with variable: " + id);
        CarInfo carInfo = carService.getById(id);
        return new ResponseEntity<>(carInfo, HttpStatus.OK);
    }

    @GetMapping("/type")
    public ResponseEntity<List<CarInfo>> getByType(@RequestParam(value = "type", required = false) CarType carType) {
        log.info("HTTP request, GET / /api/car/type with parameter genre: " + carType);
        List<CarInfo> cars = carService.findByType(carType);
        return new ResponseEntity<>(cars, HttpStatus.OK);
    }

    @DeleteMapping("/{carId}")
    public ResponseEntity<Void> deleteById(@PathVariable("carId") Integer id) {
        log.info("HTTP request, DELETE / /api/car/{carId} with variable: " + id);
        carService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
