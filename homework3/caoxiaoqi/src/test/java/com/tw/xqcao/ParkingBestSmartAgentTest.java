package com.tw.xqcao;

import com.tw.xqcao.finder.BestFinder;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class ParkingBestSmartAgentTest {

    @Test
    public void shouldParkOneCarIntoBestParkinglot() {
        ParkingAgent parkingAgent = new ParkingAgent(new BestFinder());
        Parkinglot bestParkinglot = new Parkinglot("aa", 5);
        Parkinglot lessParkinglot = new Parkinglot("bb", 5);
        bestParkinglot.parkCar(new Car("111"));
        lessParkinglot.parkCar(new Car("222"));
        lessParkinglot.parkCar(new Car("333"));
        parkingAgent.addParkinglot(lessParkinglot);
        parkingAgent.addParkinglot(bestParkinglot);

        Car expectedCar = new Car("444");
        String token = parkingAgent.parkCar(expectedCar);

        assertThat(bestParkinglot.pickCar(token), is(expectedCar));
    }
}