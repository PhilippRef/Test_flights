package com.gridnine.testing;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Search for flights")
public class PracticeTests {

    List<Flight> flightList;

    @BeforeEach
    void init() {
        flightList = FlightBuilder.createFlights();
    }

    @Test
    @DisplayName("Test find segments with arrival before departure")
    void testFindSegmentsWithArrivalBeforeDeparture() {
        FlightFilter filter = new ArrivalBeforeDepartureFilter();
        List<Flight> filteredFlights = filter.filterFlights(flightList);

        assertEquals(1, filteredFlights.size());
    }

    @Test
    @DisplayName("Test find flights with total ground time more than 2 hours")
    void testFindFlightsWithTotalGroundTimeMoreThan2Hours() {
        FlightFilter filter = new TotalGroundTimeFilter();
        List<Flight> filteredFlights = filter.filterFlights(flightList);

        assertEquals(2, filteredFlights.size());
    }

    @Test
    @DisplayName("Test find flights with departure before current time")
    void testFindFlightsWithDepartureBeforeCurrentTime() {
        FlightFilter departureFilter = new DepartureBeforeCurrentTimeFilter();
        List<Flight> filteredFlights = departureFilter.filterFlights(flightList);

        assertEquals(1, filteredFlights.size());
    }
}
