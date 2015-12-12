package com.tw.xqcao;

import java.util.Optional;

public class ParkingSmartAgent extends ParkingAgent{

    @Override
    protected Parkinglot findBestParkinglot() {
        Optional<Parkinglot> bestOption = parkinglots.stream().max(
                (a, b) -> Integer.compare(a.getParkingSpaceCount(), b.getParkingSpaceCount())
        );
        return bestOption.isPresent()? bestOption.get() : null;
    }
}
