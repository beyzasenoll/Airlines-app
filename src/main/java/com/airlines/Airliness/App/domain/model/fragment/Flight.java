package com.airlines.Airliness.App.domain.model.fragment;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class Flight {
    public BigDecimal totalPrice;
    public String currency;
    public String departureAirport;
    public String arrivalAirport;
    public Date departureDate;
    public Date arrivalDate;
    public Long flightNumber;
    public Integer seatNumber;
    private String seatClass;
}
