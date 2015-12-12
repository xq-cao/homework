package com.tw.xqcao;

import java.util.Optional;

public class ParkingBestSmartAgent extends ParkingAgent {

    @Override
    protected Optional<Parkinglot> findBestParkinglot() {
        return parkinglots.stream()
                .max((a, b) -> Double.compare(a.getParkingSpaceRate(), b.getParkingSpaceRate()));
    }
}
