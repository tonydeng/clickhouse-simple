package com.github.tonydeng.samples.airlines.repository;

import com.github.tonydeng.samples.BaseTest;
import com.github.tonydeng.samples.airlines.model.AirlineFlightsNumber;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
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
    void testGetFlightsByYear() {
        List<AirlineFlightsNumber> flights = statisticsAirlinesRepository.getFlightsByYear(2015);
        Assertions.assertNotNull(flights);
        flights.forEach(f -> log.info("airline:{},flights:{}", f.getAirline(), f.getFlights()));
    }

    @ParameterizedTest
    @ValueSource(ints = {2015, 2016, 2017, 2018})
    void testMoreYear(int year) {
        List<AirlineFlightsNumber> flights = statisticsAirlinesRepository.getFlightsByYear(year);
        Assertions.assertNotNull(flights);
        flights.forEach(f -> log.info("airline:{},flights:{}", f.getAirline(), f.getFlights()));
    }

}
