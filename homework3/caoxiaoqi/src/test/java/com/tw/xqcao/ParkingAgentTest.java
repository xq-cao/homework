package com.tw.xqcao;

import com.tw.xqcao.finder.CommonFinder;
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
        parkingAgent = new ParkingAgent(new CommonFinder());
    }

    @Test
    public void shouldParkOneCarIntoParkinglotWhenParkinglotIsNotFull() {
        Parkinglot mockParkinglot = mock(Parkinglot.class);
        when(mockParkinglot.hasSpace()).thenReturn(true);
        parkingAgent.addParkinglot(mockParkinglot);

        Car car = new Car("111");
        parkingAgent.parkCar(car);

        verify(mockParkinglot).parkCar(car);
    }

    @Test
    public void shouldParkOneCarIntoNextParkinglotWhenCurrentParkinglotIsFull() {
        parkingAgent.addParkinglot(new Parkinglot("aa", 1));
        Parkinglot mockParkinglot = mock(Parkinglot.class);
        when(mockParkinglot.hasSpace()).thenReturn(true);
        parkingAgent.addParkinglot(mockParkinglot);

        parkingAgent.parkCar(new Car("111"));
        Car car = new Car("222");
        parkingAgent.parkCar(car);

        verify(mockParkinglot).parkCar(car);
    }

    @Test
    public void shouldNotParkCarWhenAgentHaventParkinglot() {
        String token = parkingAgent.parkCar(new Car("111"));

        assertThat(token, nullValue());
    }

    @Test
    public void shouldNotParkCarWhenAgentHaventEmptyParkinglot() {
        parkingAgent.addParkinglot(new Parkinglot("aa", 1));
        parkingAgent.parkCar(new Car("111"));

        String token = parkingAgent.parkCar(new Car("222"));

        assertThat(token, nullValue());
    }

    @Test
    public void shouldPickOneCarByValidToken() {
        parkingAgent.addParkinglot(new Parkinglot("aa", 1));
        Car car = new Car("111");
        String token = parkingAgent.parkCar(car);

        assertThat(parkingAgent.pickCar(token), is(car));
    }

    @Test
    public void shouldNotPickCarWhenCarAlreadyBePicked() {
        parkingAgent.addParkinglot(new Parkinglot("aa", 1));
        String token = parkingAgent.parkCar(new Car("111"));
        parkingAgent.pickCar(token);

        assertThat(parkingAgent.pickCar(token), nullValue());
    }

    @Test
    public void shouldNotPickCarWhenTokenIsInvalid() {
        parkingAgent.addParkinglot(new Parkinglot("aa", 1));
        parkingAgent.parkCar(new Car("111"));

        assertThat(parkingAgent.pickCar("invalid token"), nullValue());
    }
}