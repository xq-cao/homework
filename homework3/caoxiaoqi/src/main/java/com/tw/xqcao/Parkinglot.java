package com.tw.xqcao;

import java.util.HashMap;
import java.util.Map;

public class Parkinglot {

    private final int maxSpaces;
    private final String name;
    private Map<String, Car> parkedCars = new HashMap<>();

    public Parkinglot(String name, int maxSpaces) {
        this.name = name;
        this.maxSpaces = maxSpaces;
    }

    public String parkCar(Car car) {
        if (parkedCars.size() < maxSpaces) {
            String token = generageToken(car);
            parkedCars.put(token, car);
            return token;
        }
        return null;
    }

    public Car pickCar(String token) {
        return parkedCars.remove(token);
    }

    public int getParkingSpaceCount() {
        return maxSpaces - parkedCars.size();
    }

    public double getParkingSpaceRate() {
        return ((double)getParkingSpaceCount() / maxSpaces);
    }

    private String generageToken(Car car) {
        return this.name + "_" + car.getCarNumber();
    }
}
