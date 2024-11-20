package com.airlines.Airliness.App.infrastracture.external.turkishairliness.request;

import com.airlines.Airliness.App.domain.model.OfferFilter;
import com.airlines.Airliness.App.infrastracture.external.pegasus.request.PegasusGetOffersDestinationDto;
import com.airlines.Airliness.App.infrastracture.external.pegasus.request.PegasusGetOffersRequest;
import lombok.AllArgsConstructor;
import lombok.Builder;

import java.util.Date;

@Builder
@AllArgsConstructor
public class ThyGetOffersRequest {
    public ThyGetOffersDestinationDto destination;
    public Date returnDate;
    public Date departureDate;

    public static ThyGetOffersRequest fromOfferFilter(OfferFilter offerFilter) {
        ThyGetOffersRequest request = ThyGetOffersRequest.builder().build();
        request.destination = ThyGetOffersDestinationDto.builder().build();
        request.destination.departureAirport = offerFilter.departureAirport;
        request.destination.arrivalAirport = offerFilter.arrivalAirport;
        request.departureDate = offerFilter.departureDate;
        request.returnDate = offerFilter.returnDate;
        return request;
    }
}
