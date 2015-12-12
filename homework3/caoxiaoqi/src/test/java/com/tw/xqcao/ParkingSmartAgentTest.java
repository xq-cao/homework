package com.tw.xqcao;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class ParkingSmartAgentTest {

    @Test
    public void shouldParkOneCarIntoParkinglotThatHaveMostParkingSpace() {
        ParkingSmartAgent parkingSmartAgent = new ParkingSmartAgent();
        Parkinglot lessSpaceParkinglot = new Parkinglot("aa", 2);
        Parkinglot moreSpaceParkinglot = new Parkinglot("bb", 3);
        parkingSmartAgent.addParkinglot(lessSpaceParkinglot);
        parkingSmartAgent.addParkinglot(moreSpaceParkinglot);

        Car expectedCar = new Car("111");
        String token = parkingSmartAgent.parkCar(expectedCar);

        assertThat(moreSpaceParkinglot.pickCar(token), is(expectedCar));
    }
}