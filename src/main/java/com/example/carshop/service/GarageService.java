package com.example.carshop.service;

import com.example.carshop.domain.Garage;
import com.example.carshop.dto.CarInfo;
import com.example.carshop.dto.GarageCreateCommand;
import com.example.carshop.dto.GarageInfo;
import com.example.carshop.repository.GarageRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class GarageService {
    private GarageRepository garageRepository;

    private ModelMapper modelMapper;

    @Autowired
    public GarageService(GarageRepository garageRepository, ModelMapper modelMapper) {
        this.garageRepository = garageRepository;
        this.modelMapper = modelMapper;
    }

    public GarageInfo saveGarage(GarageCreateCommand command) {
//        Garage garage = new Garage();
//        garage.setGarageName(command.getGarageName());
//        garage.setGarageCapacity(command.getGarageCapacity());
//
//        Garage savedGarage = garageRepository.save(garage);
//
//        GarageInfo garageInfo = new GarageInfo();
//        garageInfo.setGarageName(savedGarage.getGarageName());
//        garageInfo.setGarageCapacity(savedGarage.getGarageCapacity());
//
//        return garageInfo;
        Garage garage = modelMapper.map(command, Garage.class);
        Garage sacvedGarage = garageRepository.save(garage);
        return modelMapper.map(sacvedGarage, GarageInfo.class);
    }

    public List<GarageInfo> listGarages() {
        List<Garage> garages = garageRepository.findAll();
        List<GarageInfo> garageInfos = new ArrayList<>();
        garages.forEach(garage -> {
            GarageInfo garageInfo = modelMapper.map(garage, GarageInfo.class);
            List<CarInfo> carInfoList = garage.getCars()
                    .stream()
                    .map(car -> modelMapper.map(car, CarInfo.class))
                    .collect(Collectors.toList());
            garageInfo.setCars(carInfoList);
            garageInfos.add(garageInfo);
        });

        return garageInfos;
    }

    public Garage findGarageById(Integer garageId) {
        Optional<Garage> byId = garageRepository.findById(garageId.longValue());
        if (byId.isEmpty()) {
            //TODO Throw Exception.
        }
        return byId.get();
    }
}
