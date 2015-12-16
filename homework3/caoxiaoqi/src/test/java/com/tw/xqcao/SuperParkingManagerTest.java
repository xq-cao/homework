package com.tw.xqcao;

import com.tw.xqcao.finder.CommonFinder;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.junit.Assert.*;

public class SuperParkingManagerTest {

    private SuperParkingManager superParkingManager;

    @Before
    public void setUp() {
        Parkinglot parkinglot = new Parkinglot("aa", 2);
        ParkingAgent parkingAgent1 = new ParkingAgent(new CommonFinder());
        parkingAgent1.addParkinglot(parkinglot);

        ParkingAgent parkingAgent2 = new ParkingAgent(new CommonFinder());
        parkingAgent1.addParkinglot(parkinglot);

        ParkingManager parkingManager1 = new ParkingManager(parkingAgent1, parkingAgent2);
        ParkingManager parkingManager2 = new ParkingManager(parkingAgent1, parkingAgent2);

        superParkingManager = new SuperParkingManager(parkingManager1, parkingManager2);
    }

    @Test
    public void shouldParkOneCar() {
        Car car = new Car("SA 00001");
        String token = superParkingManager.parkCar(car);

        assertThat(token, notNullValue());
    }

    @Test
    public void shouldPickOneCar() {
        Car car = new Car("SA 00001");
        String token = superParkingManager.parkCar(car);

        assertThat(superParkingManager.pickCar(token), is(car));
    }
}