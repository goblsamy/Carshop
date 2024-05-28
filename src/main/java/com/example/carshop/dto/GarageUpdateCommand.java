package com.example.carshop.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GarageUpdateCommand {

    @NotNull
    private Integer garageCapacity;

    @NotNull
    private String garageName;
}
