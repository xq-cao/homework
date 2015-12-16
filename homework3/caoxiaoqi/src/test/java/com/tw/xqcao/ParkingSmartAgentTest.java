package com.tw.xqcao;

import com.tw.xqcao.finder.SmartFinder;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class ParkingSmartAgentTest {

    @Test
    public void shouldParkOneCarIntoParkinglotThatHaveMostParkingSpace() {
        ParkingAgent parkingAgent = new ParkingAgent(new SmartFinder());
        Parkinglot lessSpaceParkinglot = new Parkinglot("aa", 2);
        Parkinglot moreSpaceParkinglot = new Parkinglot("bb", 3);
        parkingAgent.addParkinglot(lessSpaceParkinglot);
        parkingAgent.addParkinglot(moreSpaceParkinglot);

        Car expectedCar = new Car("111");
        String token = parkingAgent.parkCar(expectedCar);

        assertThat(moreSpaceParkinglot.pickCar(token), is(expectedCar));
    }
}