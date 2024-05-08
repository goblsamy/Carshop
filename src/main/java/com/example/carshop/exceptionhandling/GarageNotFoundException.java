package com.example.carshop.exceptionhandling;

public class GarageNotFoundException extends RuntimeException {

    private final int garageId;

    public GarageNotFoundException(int garageId) {
        this.garageId = garageId;
    }

    public int getGarageId() {
        return garageId;
    }
}
