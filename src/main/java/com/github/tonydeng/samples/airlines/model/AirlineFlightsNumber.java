package com.github.tonydeng.samples.airlines.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AirlineFlightsNumber {
    private final String airline;
    private final long flights;
}
