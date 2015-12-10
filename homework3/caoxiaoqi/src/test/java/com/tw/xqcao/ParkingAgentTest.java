package com.tw.xqcao;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.nullValue;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class ParkingAgentTest {

    @Test
    public void shouldParkOneCarIntoParkinglot() {
        ParkingAgent parkingAgent = new ParkingAgent();
        Parkinglot mockParkinglot = mock(Parkinglot.class);
        parkingAgent.addParkinglot(mockParkinglot);

        parkingAgent.parkCar("111");

        verify(mockParkinglot).parkCar("111");
    }

    @Test
    public void shouldParkOneCarIntoNextParkinglotWhenCurrentParkinglotIsFull() {
        ParkingAgent parkingAgent = new ParkingAgent();
        parkingAgent.addParkinglot(new Parkinglot("aa", 1));
        Parkinglot mockParkinglot = mock(Parkinglot.class);
        parkingAgent.addParkinglot(mockParkinglot);

        parkingAgent.parkCar("111");
        parkingAgent.parkCar("222");

        verify(mockParkinglot).parkCar("222");
    }

    @Test
    public void shouldNotParkCarWhenAgentHaventParkinglot() {
        ParkingAgent parkingAgent = new ParkingAgent();
        String token = parkingAgent.parkCar("111");

        assertThat(token, nullValue());
    }

    @Test
    public void shouldNotParkCarWhenAgentHaventEmptyParkinglot() {
        ParkingAgent parkingAgent = new ParkingAgent();
        parkingAgent.addParkinglot(new Parkinglot("aa", 1));
        parkingAgent.parkCar("111");

        String token = parkingAgent.parkCar("222");

        assertThat(token, nullValue());
    }

    @Test
    public void shouldPickOneCarByValidToken() {
        ParkingAgent parkingAgent = new ParkingAgent();
        parkingAgent.addParkinglot(new Parkinglot("aa", 1));
        String token = parkingAgent.parkCar("111");
        String carNumber = parkingAgent.pickCar(token);

        assertThat(carNumber, is("111"));
    }

    @Test
    public void shouldNotPickCarWhenCarAlreadyBePicked() {
        ParkingAgent parkingAgent = new ParkingAgent();
        parkingAgent.addParkinglot(new Parkinglot("aa", 1));
        String token = parkingAgent.parkCar("111");
        parkingAgent.pickCar(token);
        String carNumber = parkingAgent.pickCar(token);

        assertThat(carNumber, nullValue());
    }

    @Test
    public void shouldNotPickCarWhenTokenIsInvalid() {
        ParkingAgent parkingAgent = new ParkingAgent();
        parkingAgent.addParkinglot(new Parkinglot("aa", 1));
        parkingAgent.parkCar("111");

        String carNumber = parkingAgent.pickCar("invalid token");

        assertThat(carNumber, nullValue());
    }
}