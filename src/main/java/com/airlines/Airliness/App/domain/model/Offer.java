package com.airlines.Airliness.App.domain.model;

import com.airlines.Airliness.App.dto.DestinationDto;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
@Builder
public class Offer {
    public BigDecimal totalPrice;
    public String currency;
    public String departureAirport;
    public String arrivalAirport;
    public Date departureDate;
    public Date arrivalDate;
    public Long flightNumber;
    public Integer seatNumber;

}
