package com.airlines.Airliness.App.infrastracture.external.pegasus.request;

import com.airlines.Airliness.App.domain.model.OfferFilter;
import com.airlines.Airliness.App.dto.DestinationDto;
import lombok.AllArgsConstructor;
import lombok.Builder;

import java.util.Date;

@Builder
@AllArgsConstructor
public class PegasusGetOffersRequest {
    public PegasusGetOffersDestinationDto destination;
    public Date departureDate;
    public Date returnDate;

    public static PegasusGetOffersRequest fromOfferFilter(OfferFilter offerFilter) {
        PegasusGetOffersRequest request = PegasusGetOffersRequest.builder().build();
        request.destination = PegasusGetOffersDestinationDto.builder().build();
        request.destination.departureAirport = offerFilter.departureAirport;
        request.destination.arrivalAirport = offerFilter.arrivalAirport;
        request.departureDate = offerFilter.departureDate;
        request.returnDate = offerFilter.returnDate;
        return request;
    }
}
