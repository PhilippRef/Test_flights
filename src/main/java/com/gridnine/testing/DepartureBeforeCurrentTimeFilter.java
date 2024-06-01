package com.gridnine.testing;

import java.time.LocalDateTime;
import java.util.List;

public class DepartureBeforeCurrentTimeFilter implements FlightFilter {
    @Override
    public List<Flight> filterFlights(List<Flight> flights) {
        LocalDateTime currentDateTime = LocalDateTime.now();
        return flights.stream()
                .filter(flight -> flight.getSegments().stream()
                        .allMatch(segment -> segment.getDepartureDate().isBefore(currentDateTime)))
                .toList();
    }
}