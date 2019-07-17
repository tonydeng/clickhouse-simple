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

    /**
     * 获取某一年不同航空公司的飞行次数
     *
     * @param year
     * @return
     */
    public List<AirlineFlightsNumber> getFlightsByYear(int year) {
        return jdbcTemplate.query(
                "select Carrier,sum(AirlineID) as flights from ontime where Year = " + year + " group by Carrier order by flights desc",
                new Integer[]{year}, (rs, rowNum) -> new AirlineFlightsNumber(
                        rs.getString("Carrier"),
                        rs.getLong("flights"))
        );
    }

    public List<AirlineFlightsNumber> getFilghtsByYearAndMonth(int year, int month) {
        return jdbcTemplate.query(
                "",
                new Integer[]{year, month}, (rs, rowNum) -> new AirlineFlightsNumber(
                        rs.getString("Carrier"),
                        rs.getLong("flights")
                )
        );
    }
}
