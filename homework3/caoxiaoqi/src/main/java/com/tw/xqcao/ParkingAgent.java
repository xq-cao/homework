package com.tw.xqcao;

import java.util.ArrayList;
import java.util.List;

public class ParkingAgent {

    private List<Parkinglot> parkinglots = new ArrayList<>();

    public void addParkinglot(Parkinglot parkinglot) {
        parkinglots.add(parkinglot);
    }

    public String parkCar(String carNumber) {
        for (Parkinglot parkinglot : parkinglots) {
            String token = parkinglot.parkCar(carNumber);
            if (token != null)
                return token;
        }
        return null;
    }

    public String pickCar(String token) {
        for (Parkinglot parkinglot : parkinglots) {
            String carNumber = parkinglot.pickCar(token);
            if (carNumber != null)
                return carNumber;
        }
        return null;
    }
}
