package com.airlines.Airliness.App.infrastracture.external.pegasus.request;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class PegasusGetOffersDestinationDto {
    public String departureAirport;
    public String arrivalAirport;
}
