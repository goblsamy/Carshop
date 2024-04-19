package com.example.carshop.service;

import com.example.carshop.domain.Garage;
import com.example.carshop.dto.GarageCreateCommand;
import com.example.carshop.dto.GarageInfo;
import com.example.carshop.repository.GarageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class GarageService {
    private GarageRepository garageRepository;

    @Autowired
    public GarageService(GarageRepository garageRepository) {
        this.garageRepository = garageRepository;
    }

    public GarageInfo saveGarage(GarageCreateCommand command) {
        Garage garage = new Garage();
        garage.setGarageName(command.getGarageName());
        garage.setGarageCapacity(command.getGarageCapacity());

        Garage savedGarage = garageRepository.save(garage);

        GarageInfo garageInfo = new GarageInfo();
        garageInfo.setGarageName(savedGarage.getGarageName());
        garageInfo.setGarageCapacity(savedGarage.getGarageCapacity());

        return garageInfo;
    }
}
