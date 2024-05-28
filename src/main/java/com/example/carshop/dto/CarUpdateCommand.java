package com.example.carshop.dto;


import com.example.carshop.domain.CarType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CarUpdateCommand {

    @NotNull
    CarType carType;

    @NotNull
    String carName;


}
