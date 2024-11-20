package com.airlines.Airliness.App.infrastracture.external.turkishairliness.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Builder
@Data
@AllArgsConstructor
public class ThyGetFlightInformation {
    public String departureAirport;

    public String arrivalAirport;
    public Date departureDate;
    public Date arrivalDate;
    public Long flightNumber;
    public Integer seatNumber;
}

