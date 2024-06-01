package com.gridnine.testing;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Flight> flights = FlightBuilder.createFlights();

        FlightFilter departureFilter = new DepartureBeforeCurrentTimeFilter();
        List<Flight> filteredFlights1 = departureFilter.filterFlights(flights);
        System.out.println("Filtered flights by departure before current time:");
        filteredFlights1.forEach(System.out::println);

        FlightFilter arrivalFilter = new ArrivalBeforeDepartureFilter();
        List<Flight> filteredFlights2 = arrivalFilter.filterFlights(flights);
        System.out.println("Filtered flights by arrival before departure:");
        filteredFlights2.forEach(System.out::println);

        FlightFilter groundTimeFilter = new TotalGroundTimeFilter();
        List<Flight> filteredFlights3 = groundTimeFilter.filterFlights(flights);
        System.out.println("Filtered flights by total ground time:");
        filteredFlights3.forEach(System.out::println);
    }
}
