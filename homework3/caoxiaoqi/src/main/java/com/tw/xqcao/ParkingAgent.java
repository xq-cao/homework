package com.tw.xqcao;

import java.util.ArrayList;
import java.util.List;

public class ParkingAgent {

    protected List<Parkinglot> parkinglots = new ArrayList<>();

    public void addParkinglot(Parkinglot parkinglot) {
        parkinglots.add(parkinglot);
    }

    public String parkCar(String carNumber) {
        Parkinglot parkinglot = findBestParkinglot();
        if (parkinglot != null) {
            return parkinglot.parkCar(carNumber);
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

    protected Parkinglot findBestParkinglot() {
        for (Parkinglot parkinglot : parkinglots) {
            if (parkinglot.getParkingSpaceCount() > 0) {
                return parkinglot;
            }
        }
        return null;
    }
}
