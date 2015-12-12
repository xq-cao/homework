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
        Optional<Parkinglot> bestParkinglot = findBestParkinglot();
        if (bestParkinglot.isPresent()) {
            return bestParkinglot.get().parkCar(carNumber);
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

    protected Optional<Parkinglot> findBestParkinglot() {
        return parkinglots.stream()
                .filter(parkinglot -> parkinglot.getParkingSpaceCount() > 0)
                .findFirst();
    }
}
