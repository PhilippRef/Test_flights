package com.gridnine.testing;

import java.time.Duration;
import java.util.List;

public class TotalGroundTimeFilter implements FlightFilter {
    @Override
    public List<Flight> filterFlights(List<Flight> flights) {
        return flights.stream()
                .filter(this::isFlightHasMoreThan2HoursGroundTime)
                .toList();
    }

    private boolean isFlightHasMoreThan2HoursGroundTime(Flight flight) {
        List<Segment> segments = flight.getSegments();
        Duration groundTime = Duration.ZERO;

        for (int i = 0; i < segments.size() - 1; i++) {
            Segment currentSegment = segments.get(i);
            Segment nextSegment = segments.get(i + 1);

            groundTime = groundTime.plus(Duration.between
                    (currentSegment.getArrivalDate(), nextSegment.getDepartureDate())
            );
            if (groundTime.toHours() > 2) {
                return true;
            }
        }
        return false;
    }
}