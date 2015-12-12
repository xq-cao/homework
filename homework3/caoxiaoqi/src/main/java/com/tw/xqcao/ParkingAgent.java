package com.tw.xqcao;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ParkingAgent {

    protected List<Parkinglot> parkinglots = new ArrayList<>();

    public void addParkinglot(Parkinglot parkinglot) {
        parkinglots.add(parkinglot);
    }

    public String parkCar(Car car) {
        Optional<Parkinglot> bestParkinglot = findBestParkinglot();
        return bestParkinglot.isPresent()? bestParkinglot.get().parkCar(car) : null;
    }

    public Car pickCar(String token) {
        for (Parkinglot parkinglot : parkinglots) {
            Car car = parkinglot.pickCar(token);
            if (car != null)
                return car;
        }
        return null;
    }

    protected Optional<Parkinglot> findBestParkinglot() {
        return parkinglots.stream()
                .filter(parkinglot -> parkinglot.getParkingSpaceCount() > 0)
                .findFirst();
    }
}
