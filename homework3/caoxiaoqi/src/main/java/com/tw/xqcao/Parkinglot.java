package com.tw.xqcao;

import java.util.HashMap;
import java.util.Map;

public class Parkinglot {

    private final int maxSpaces;
    private final String name;
    private Map<String, String> parkedCars = new HashMap<>();

    public Parkinglot(String name, int maxSpaces) {
        this.name = name;
        this.maxSpaces = maxSpaces;
    }

    public String parkCar(String carNumber) {
        if (parkedCars.size() < maxSpaces) {
            String token = generageToken(carNumber);
            parkedCars.put(token, carNumber);
            return token;
        }
        return null;
    }

    public String pickCar(String token) {
        return parkedCars.remove(token);
    }

    public int getParkingSpaceCount() {
        return maxSpaces - parkedCars.size();
    }

    public double getParkingSpaceRate() {
        return ((double)getParkingSpaceCount() / maxSpaces);
    }

    private String generageToken(String carNumber) {
        return this.name + "_" + carNumber;
    }
}
