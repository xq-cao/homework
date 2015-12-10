package com.tw.xqcao;

public class ParkingSmartAgent extends ParkingAgent{

    @Override
    protected Parkinglot getAValidParkinglot() {
        Parkinglot bestParkinglot = null;
        for (Parkinglot parkinglot : parkinglots) {
            if (bestParkinglot == null || parkinglot.getParkingSpaceCount() > bestParkinglot.getParkingSpaceCount()) {
                bestParkinglot = parkinglot;
            }
        }
        return bestParkinglot;
    }
}
