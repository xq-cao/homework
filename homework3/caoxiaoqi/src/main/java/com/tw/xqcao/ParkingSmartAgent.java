package com.tw.xqcao;

import java.util.Optional;

public class ParkingSmartAgent extends ParkingAgent{

    @Override
    protected Optional<Parkinglot> findBestParkinglot() {
        return parkinglots.stream()
                .max((a, b) -> Integer.compare(a.getParkingSpaceCount(), b.getParkingSpaceCount()));
    }
}
