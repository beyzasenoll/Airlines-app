package com.airlines.Airliness.App.infrastracture.external.turkishairliness.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
@AllArgsConstructor
public class ThyGetOffersDestinationDto {
    public String departureAirport;
    public String arrivalAirport;
}
