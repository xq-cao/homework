package com.tw.xqcao;

import java.util.Arrays;
import java.util.List;

public class ParkingManager implements Parking {

    private final List<Parking> parkings;

    public ParkingManager(Parking... parkingList) {
        parkings = Arrays.asList(parkingList);
    }

    @Override
    public String parkCar(Car car) {
        for (Parking parking : parkings) {
            String token = parking.parkCar(car);
            if (token != null)
                return token;
        }
        return null;
    }

    @Override
    public Car pickCar(String token) {
        for (Parking parking : parkings) {
            Car car = parking.pickCar(token);
            if (car != null)
                return car;
        }
        return null;
    }
}
