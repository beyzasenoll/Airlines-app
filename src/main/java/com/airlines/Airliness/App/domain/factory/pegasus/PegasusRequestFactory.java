package com.airlines.Airliness.App.domain.factory.pegasus;

import com.airlines.Airliness.App.domain.model.OfferFilter;
import com.airlines.Airliness.App.infrastracture.external.pegasus.request.PegasusGetOffersDestinationDto;
import com.airlines.Airliness.App.infrastracture.external.pegasus.request.PegasusGetOffersRequest;

public class PegasusRequestFactory {
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
