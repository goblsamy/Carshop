package com.example.carshop.service;

import com.example.carshop.domain.Car;
import com.example.carshop.domain.Garage;
import com.example.carshop.dto.CarInfo;
import com.example.carshop.dtoű.CarCreateCommand;
import com.example.carshop.exceptionhandling.CarNotFoundException;
import com.example.carshop.repository.CarRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class CarService {

    private ModelMapper modelMapper;

    private GarageService garageService;

    private CarRepository carRepository;

    @Autowired
    public CarService(ModelMapper modelMapper, GarageService garageService, CarRepository carRepository) {
        this.modelMapper = modelMapper;
        this.garageService = garageService;
        this.carRepository = carRepository;
    }

    public CarInfo saveCar(CarCreateCommand command) {
        Car carToSave = modelMapper.map(command, Car.class);
        Garage garageById = garageService.findGarageById(command.getGarageId());
        carToSave.setGarage(garageById);
        Car saved = carRepository.save(carToSave);
        return modelMapper.map(saved, CarInfo.class);
    }

    public List<CarInfo> listCars() {
        return carRepository.findAll()
                .stream()
                .map(car -> modelMapper.map(car, CarInfo.class))
                .collect(Collectors.toList());
    }

    public CarInfo getById(Integer id) {
        return modelMapper.map(findById(id), CarInfo.class);
    }

    private Car findById(Integer id) {
        Optional<Car> carOptional = carRepository.findById(id.longValue());
        if (carOptional.isEmpty()) {
            throw new CarNotFoundException(id);
        }
        return carOptional.get();
    }
}
