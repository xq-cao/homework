package com.tw.xqcao;

import com.tw.xqcao.finder.CommonFinder;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.junit.Assert.*;

public class ParkingManagerTest {

    private ParkingManager parkingManager;

    @Before
    public void setUp() {
        Parkinglot parkinglot = new Parkinglot("aa", 2);
        ParkingAgent parkingAgent1 = new ParkingAgent(new CommonFinder());
        parkingAgent1.addParkinglot(parkinglot);

        ParkingAgent parkingAgent2 = new ParkingAgent(new CommonFinder());
        parkingAgent1.addParkinglot(parkinglot);

        parkingManager = new ParkingManager(parkingAgent1, parkingAgent2);
    }

    @Test
    public void shouldParkOneCar() {
        Car car = new Car("SA 00001");
        String token = parkingManager.parkCar(car);

        assertThat(token, notNullValue());
    }

    @Test
    public void shouldPickOneCar() {
        Car car = new Car("SA 00001");
        String token = parkingManager.parkCar(car);

        assertThat(parkingManager.pickCar(token), is(car));
    }
}