package com.tw.xqcao;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
        Optional<Parkinglot> firstOption = parkinglots.stream()
                .filter(parkinglot -> parkinglot.getParkingSpaceCount() > 0)
                .findFirst();
        return firstOption.isPresent()? firstOption.get() : null;
    }
}
