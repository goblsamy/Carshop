package com.example.carshop.dto;

import com.example.carshop.domain.CarType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CarCreateCommand {
    @NotNull
    private CarType carType;

    @NotBlank(message = "Name cannot be blank.")
    private String carName;

    @NotNull
    private Integer garageId;


}
