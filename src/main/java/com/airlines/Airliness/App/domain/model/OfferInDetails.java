package com.airlines.Airliness.App.domain.model;

import com.airlines.Airliness.App.domain.model.fragment.Passenger;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Data
public class OfferInDetails {
    public BigDecimal totalPrice;
    public String currency;
    public String departureAirport;
    public String arrivalAirport;
    public Date departureDate;
    public Date arrivalDate;
    public Long flightNumber;
    public Integer seatNumber;

    private String seatClass;
    private Boolean isRefundable;
    private Boolean hasMealIncluded;

    // Passenger details
    Passenger passenger;

    // Flight provider details
    private String airlineName;
    private String airlineCode;
    private String bookingReference;

    // Additional services
    private List<String> additionalServices; // e.g., "Extra Baggage", "Lounge Access"
    private BigDecimal additionalServiceCost;
}
