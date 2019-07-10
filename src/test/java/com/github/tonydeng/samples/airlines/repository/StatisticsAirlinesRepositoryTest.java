package com.github.tonydeng.samples.airlines.repository;

import com.github.tonydeng.samples.BaseTest;
import com.github.tonydeng.samples.airlines.model.AirlineFlightsNumber;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Slf4j
public class StatisticsAirlinesRepositoryTest extends BaseTest {
    @Autowired
    private StatisticsAirlinesRepository statisticsAirlinesRepository;

    @Test
    void test() {
        log.info("test");
    }

    @Test
    void testGetFlightsByYear(){
        List<AirlineFlightsNumber> flights = statisticsAirlinesRepository.getFlightsByYear(2015);
        Assertions.assertNotNull(flights);
        flights.forEach(f -> log.info("airline:{},flights:{}",f.getAirline(),f.getFlights()));
    }
}
