package com.tw.xqcao;

import java.util.HashMap;
import java.util.Map;

public class Parkinglot {

    private final int maxSpaces;
    private final String name;
    private Map<String, String> parkingSpace = new HashMap<>();

    public Parkinglot(String name, int maxSpaces) {
        this.name = name;
        this.maxSpaces = maxSpaces;
    }

    public String parkCar(String carNumber) {
        if (parkingSpace.size() < maxSpaces) {
            String token = generageAToken(carNumber);
            parkingSpace.put(generageAToken(carNumber), carNumber);
            return token;
        }
        return null;
    }

    public String pickCar(String token) {
        return parkingSpace.remove(token);
    }

    private String generageAToken(String carNumber) {
        return this.name + "_" + carNumber;
    }

    public int getParkingSpaceCount() {
        return maxSpaces - parkingSpace.size();
    }
}
