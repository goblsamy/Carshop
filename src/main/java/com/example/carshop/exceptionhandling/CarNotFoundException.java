package com.example.carshop.exceptionhandling;

public class CarNotFoundException extends RuntimeException {

    private final int carId;

    public CarNotFoundException(int carId) {
        this.carId = carId;
    }

    public int getCarId() {
        return carId;
    }
}
