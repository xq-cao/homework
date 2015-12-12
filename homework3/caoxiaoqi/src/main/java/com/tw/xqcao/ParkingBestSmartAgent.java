package com.tw.xqcao;

public class ParkingBestSmartAgent extends ParkingAgent {

    @Override
    protected Parkinglot findBestParkinglot() {
        Parkinglot bestParkinglot = null;
        for (Parkinglot parkinglot : parkinglots) {
            if (bestParkinglot == null || parkinglot.getParkingSpaceRate() > bestParkinglot.getParkingSpaceRate()) {
                bestParkinglot = parkinglot;
            }
        }
        return bestParkinglot;
    }
}
