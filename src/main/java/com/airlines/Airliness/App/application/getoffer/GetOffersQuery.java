package com.airlines.Airliness.App.application.getoffer;

import lombok.Data;

import java.util.Date;

@Data
public class GetOffersQuery {
    public String departureAirport;
    public String arrivalAirport;
    public Date departureDate;
    public Date returnDate;
}
