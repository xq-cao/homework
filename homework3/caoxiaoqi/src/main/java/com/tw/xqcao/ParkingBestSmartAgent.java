package com.tw.xqcao;

import java.util.Optional;

public class ParkingBestSmartAgent extends ParkingAgent {

    @Override
    protected Parkinglot findBestParkinglot() {
        Optional<Parkinglot> bestOption = parkinglots.stream().max(
                (a, b) -> Double.compare(a.getParkingSpaceRate(), b.getParkingSpaceRate())
        );
        return bestOption.isPresent()? bestOption.get() : null;
    }
}
