package com.airlines.Airliness.App.infrastracture.external.pegasus.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
@Builder
public class PegasusGetOffersFlightInformation {
    public String departureAirport;
    public String arrivalAirport;
    public Date departureDate;
    public Date arrivalDate;
    public Long flightNumber;
    public Integer seatNumber;
}
