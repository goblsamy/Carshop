package com.example.carshop.dto;

import com.example.carshop.domain.CarType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CarInfo {
    private CarType carType;
    private String carName;
}
