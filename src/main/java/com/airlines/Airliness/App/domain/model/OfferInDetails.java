package com.airlines.Airliness.App.domain.model;

import com.airlines.Airliness.App.domain.model.fragment.Flight;
import com.airlines.Airliness.App.domain.model.fragment.Passenger;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Data
public class OfferInDetails {
    private Flight flight;
    Passenger passenger;
    private Boolean isRefundable;
    private Boolean hasMealIncluded;


    // Flight provider details
    private String airlineName;
    private String airlineCode;
    private String bookingReference;

    // Additional services
    private List<String> additionalServices; // e.g., "Extra Baggage", "Lounge Access"
    private BigDecimal additionalServiceCost;
}
