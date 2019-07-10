package com.github.tonydeng.samples.airlines.repository;

import com.github.tonydeng.samples.airlines.model.AirlineFlightsNumber;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StatisticsAirlinesRepository {

    private JdbcTemplate jdbcTemplate;

    public StatisticsAirlinesRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<AirlineFlightsNumber> getFlightsByYear(int year){
        return jdbcTemplate.query(
                "select Carrier,sum(AirlineID) as flights from ontime where Year = ? group by Carrier order by flights desc",
                new Object[]{year},(rs,rowNum) -> {
                    return new AirlineFlightsNumber(
                            rs.getString("Carrier"),
                            rs.getLong("flights"));
                }
        );
    }
}
