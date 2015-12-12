package com.tw.xqcao;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class ParkingBestSmartAgentTest {

    @Test
    public void shouldParkOneCarIntoBestParkinglot() {
        ParkingBestSmartAgent parkingBestSmartAgent = new ParkingBestSmartAgent();
        Parkinglot bestParkinglot = new Parkinglot("aa", 5);
        Parkinglot lessParkinglot = new Parkinglot("bb", 5);
        bestParkinglot.parkCar(new Car("111"));
        lessParkinglot.parkCar(new Car("222"));
        lessParkinglot.parkCar(new Car("333"));
        parkingBestSmartAgent.addParkinglot(lessParkinglot);
        parkingBestSmartAgent.addParkinglot(bestParkinglot);

        Car expectedCar = new Car("444");
        String token = parkingBestSmartAgent.parkCar(expectedCar);

        assertThat(bestParkinglot.pickCar(token), is(expectedCar));
    }
}