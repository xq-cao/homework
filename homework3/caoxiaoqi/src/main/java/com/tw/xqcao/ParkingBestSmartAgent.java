package com.tw.xqcao;

public class ParkingBestSmartAgent extends ParkingAgent {

    @Override
    protected Parkinglot getAValidParkinglot() {
        Parkinglot bestParkinglot = null;
        for (Parkinglot parkinglot : parkinglots) {
            if (bestParkinglot == null || parkinglot.getParkingSpaceRate() > bestParkinglot.getParkingSpaceRate()) {
                bestParkinglot = parkinglot;
            }
        }
        return bestParkinglot;
    }
}
