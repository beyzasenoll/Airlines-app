package com.airlines.Airliness.App.infrastracture.external.turkishairliness.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Builder
@AllArgsConstructor
@Data
public class ThyGetOffersResponse {
    public ThyGetOffersPrice offersPrice;
    public ThyGetFlightInformation flightInformation;
}
