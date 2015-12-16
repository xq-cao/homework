package com.tw.xqcao;

import java.util.Arrays;
import java.util.List;

public class ParkingManager {

    private final List<ParkingAgent> parkingAgents;

    public ParkingManager(ParkingAgent... parkingAgentList) {
        parkingAgents = Arrays.asList(parkingAgentList);
    }

    public String parkCar(Car car) {
        for (ParkingAgent parkingAgent : parkingAgents) {
            String token = parkingAgent.parkCar(car);
            if (token != null)
                return token;
        }
        return null;
    }

    public Car pickCar(String token) {
        for (ParkingAgent parkingAgent : parkingAgents) {
            Car car = parkingAgent.pickCar(token);
            if (car != null)
                return car;
        }
        return null;
    }
}
