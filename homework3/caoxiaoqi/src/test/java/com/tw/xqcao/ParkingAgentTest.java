package com.tw.xqcao;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.nullValue;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class ParkingAgentTest {

    ParkingAgent parkingAgent = null;

    @Before
    public void setUp() {
        parkingAgent = new ParkingAgent();
    }

    @Test
    public void shouldParkOneCarIntoParkinglotWhenParkinglotIsNotFull() {
        Parkinglot mockParkinglot = mock(Parkinglot.class);
        when(mockParkinglot.getParkingSpaceCount()).thenReturn(2);
        parkingAgent.addParkinglot(mockParkinglot);

        parkingAgent.parkCar("111");

        verify(mockParkinglot).parkCar("111");
    }

    @Test
    public void shouldParkOneCarIntoNextParkinglotWhenCurrentParkinglotIsFull() {
        parkingAgent.addParkinglot(new Parkinglot("aa", 1));
        Parkinglot mockParkinglot = mock(Parkinglot.class);
        when(mockParkinglot.getParkingSpaceCount()).thenReturn(2);
        parkingAgent.addParkinglot(mockParkinglot);

        parkingAgent.parkCar("111");
        parkingAgent.parkCar("222");

        verify(mockParkinglot).parkCar("222");
    }

    @Test
    public void shouldNotParkCarWhenAgentHaventParkinglot() {
        String token = parkingAgent.parkCar("111");

        assertThat(token, nullValue());
    }

    @Test
    public void shouldNotParkCarWhenAgentHaventEmptyParkinglot() {
        parkingAgent.addParkinglot(new Parkinglot("aa", 1));
        parkingAgent.parkCar("111");

        String token = parkingAgent.parkCar("222");

        assertThat(token, nullValue());
    }

    @Test
    public void shouldPickOneCarByValidToken() {
        parkingAgent.addParkinglot(new Parkinglot("aa", 1));
        String token = parkingAgent.parkCar("111");
        String carNumber = parkingAgent.pickCar(token);

        assertThat(carNumber, is("111"));
    }

    @Test
    public void shouldNotPickCarWhenCarAlreadyBePicked() {
        parkingAgent.addParkinglot(new Parkinglot("aa", 1));
        String token = parkingAgent.parkCar("111");
        parkingAgent.pickCar(token);
        String carNumber = parkingAgent.pickCar(token);

        assertThat(carNumber, nullValue());
    }

    @Test
    public void shouldNotPickCarWhenTokenIsInvalid() {
        parkingAgent.addParkinglot(new Parkinglot("aa", 1));
        parkingAgent.parkCar("111");

        String carNumber = parkingAgent.pickCar("invalid token");

        assertThat(carNumber, nullValue());
    }
}