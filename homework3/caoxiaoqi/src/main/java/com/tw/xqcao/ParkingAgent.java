package com.tw.xqcao;

import com.tw.xqcao.finder.Finder;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ParkingAgent implements Parking{

    private final Finder finder;
    protected List<Parkinglot> parkinglots = new ArrayList<>();

    public ParkingAgent(Finder finder) {
        this.finder = finder;
    }

    public void addParkinglot(Parkinglot parkinglot) {
        parkinglots.add(parkinglot);
    }

    @Override
    public String parkCar(Car car) {
        Optional<Parkinglot> bestParkinglot = finder.findBestParkinglot(parkinglots);
        return bestParkinglot.isPresent()? bestParkinglot.get().parkCar(car) : null;
    }

    @Override
    public Car pickCar(String token) {
        Optional<Parkinglot> containsParkinglot = findContainsParkinglot(token);
        return containsParkinglot.isPresent()? containsParkinglot.get().pickCar(token) : null;
    }

    private Optional<Parkinglot> findContainsParkinglot(String token) {
        return parkinglots.stream()
                .filter(parkinglot -> parkinglot.containsCar(token))
                .findFirst();
    }
}
