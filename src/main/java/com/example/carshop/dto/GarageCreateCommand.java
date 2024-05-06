package com.example.carshop.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GarageCreateCommand {

    @NotNull
    @Min(value = 10, message = "Must be at least 10!")
    private Integer garageCapacity;

    @Size(max = 25, message = "Max char size: 25!")
    private String garageName;
}
