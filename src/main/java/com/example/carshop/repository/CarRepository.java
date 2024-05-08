package com.example.carshop.repository;

import com.example.carshop.domain.Car;
import com.example.carshop.domain.CarType;
import com.example.carshop.dto.CarInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CarRepository extends JpaRepository<Car, Long> {
    @Query("select c from Car c where c.carType=:carType")
    List<Car> findByCarType(CarType carType);
}
