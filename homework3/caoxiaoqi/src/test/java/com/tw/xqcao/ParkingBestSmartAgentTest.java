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
        bestParkinglot.parkCar("111");
        lessParkinglot.parkCar("222");
        lessParkinglot.parkCar("333");
        parkingBestSmartAgent.addParkinglot(lessParkinglot);
        parkingBestSmartAgent.addParkinglot(bestParkinglot);

        String token = parkingBestSmartAgent.parkCar("444");
        String carNumber = bestParkinglot.pickCar(token);

        assertThat(carNumber, is("444"));
    }
}