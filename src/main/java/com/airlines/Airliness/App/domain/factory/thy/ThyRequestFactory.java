package com.airlines.Airliness.App.domain.factory.thy;

import com.airlines.Airliness.App.domain.model.OfferFilter;
import com.airlines.Airliness.App.infrastracture.external.turkishairliness.request.ThyGetOffersDestinationDto;
import com.airlines.Airliness.App.infrastracture.external.turkishairliness.request.ThyGetOffersRequest;
import org.springframework.stereotype.Component;


public class ThyRequestFactory {
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
