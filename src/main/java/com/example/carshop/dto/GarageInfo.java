package com.example.carshop.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GarageInfo {
    private Integer garageCapacity;
    private String garageName;
    private List<CarInfo> cars;
}
