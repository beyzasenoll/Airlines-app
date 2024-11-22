package com.airlines.Airliness.App.domain.model;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
public class OfferFilter {
    public String departureAirport;
    public String arrivalAirport;
    public Date departureDate;
    public Date returnDate;
}
