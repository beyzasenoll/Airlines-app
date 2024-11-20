package com.airlines.Airliness.App.infrastracture.external.pegasus.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class PegasusGetOffersResponse {
    public PegasusGetOffersPrice price;
    public PegasusGetOffersFlightInformation flightInformation;
}


