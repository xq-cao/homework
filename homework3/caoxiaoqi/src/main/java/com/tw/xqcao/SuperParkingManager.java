package com.tw.xqcao;

import java.util.Arrays;
import java.util.List;

public class SuperParkingManager {

    private final List<ParkingManager> parkingManagers;

    public SuperParkingManager(ParkingManager... parkingManagerList) {
        parkingManagers = Arrays.asList(parkingManagerList);
    }

    public String parkCar(Car car) {
        for (ParkingManager parkingManager : parkingManagers) {
            String token = parkingManager.parkCar(car);
            if (token != null)
                return token;
        }
        return null;
    }

    public Car pickCar(String token) {
        for (ParkingManager parkingManager : parkingManagers) {
            Car car = parkingManager.pickCar(token);
            if (car != null)
                return car;
        }
        return null;
    }
}
