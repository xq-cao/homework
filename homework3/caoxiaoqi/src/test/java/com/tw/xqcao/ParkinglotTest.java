package com.tw.xqcao;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.nullValue;
import static org.junit.Assert.*;

public class ParkinglotTest {

    @Test
    public void shouldGetParkingSpaceCount() {
        Parkinglot parkinglot = new Parkinglot("aa", 2);

        assertThat(parkinglot.getParkingSpaceCount(), is(2));
    }

    @Test
    public void shouldGetOneRateWhenNoCarInParkinglot() {
        Parkinglot parkinglot = new Parkinglot("aa", 2);

        assertThat(parkinglot.getParkingSpaceRate(), is(1.0));
    }

    @Test
    public void shouldGetCorrectRateWhenNoCarInParkinglot() {
        Parkinglot parkinglot = new Parkinglot("aa", 2);
        parkinglot.parkCar("111");

        assertThat(parkinglot.getParkingSpaceRate(), is(0.5));
    }

    @Test
    public void shouldGetZeroRateWhenParkinglotIsFull() {
        Parkinglot parkinglot = new Parkinglot("aa", 2);
        parkinglot.parkCar("111");
        parkinglot.parkCar("222");

        assertThat(parkinglot.getParkingSpaceRate(), is(0.0));
    }

    @Test
    public void shouldGetCorrectParkingSpaceCountWhenParkOneCarAfter() {
        Parkinglot parkinglot = new Parkinglot("aa", 3);
        parkinglot.parkCar("111");

        assertThat(parkinglot.getParkingSpaceCount(), is(2));
    }

    @Test
    public void shouldParkOneCar() {
        Parkinglot parkinglot = new Parkinglot("aa", 1);
        String token = parkinglot.parkCar("111");
        
        assertThat(token, is("aa_111"));
    }
    
    @Test
    public void shouldNotParkCarWhenParkinglotIsFull() {
        Parkinglot parkinglot = new Parkinglot("aa", 1);
        parkinglot.parkCar("111");
        String token = parkinglot.parkCar("222");
        
        assertThat(token, nullValue());
    }
    
    @Test
    public void shouldPickOneCarByToken() {
        Parkinglot parkinglot = new Parkinglot("aa", 1);
        String token = parkinglot.parkCar("111");
        String carNumber = parkinglot.pickCar(token);
        
        assertThat(carNumber, is("111"));
    }
    
    @Test
    public void shouldNotPickOneCarWhenItAlreadyBePicked() {
        Parkinglot parkinglot = new Parkinglot("aa", 1);
        String token = parkinglot.parkCar("111");
        parkinglot.pickCar(token);
        String carNumber = parkinglot.pickCar(token);
        
        assertThat(carNumber, nullValue());
    }
    
    @Test
    public void shouldNotPickOneCarWithAInvalidToken() {
        Parkinglot parkinglot = new Parkinglot("aa", 1);
        parkinglot.parkCar("111");
        
        String carNumber = parkinglot.pickCar("invalid token");
        
        assertThat(carNumber, nullValue());
    }
}