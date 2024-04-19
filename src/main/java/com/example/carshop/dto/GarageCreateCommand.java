package com.example.carshop.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GarageCreateCommand {

    private Integer garageCapacity;
    private String garageName;
}
