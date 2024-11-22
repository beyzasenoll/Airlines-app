package com.airlines.Airliness.App.domain.factory.thy;

import com.airlines.Airliness.App.domain.model.Offer;
import com.airlines.Airliness.App.infrastracture.external.turkishairliness.response.ThyGetOffersResponse;
import org.springframework.stereotype.Component;



public class ThyResponseFactory {
    public static Offer fromOfferResponse(ThyGetOffersResponse thyGetOffersResponse){
        return Offer.builder().currency(thyGetOffersResponse.offersPrice.currency)
                .departureDate(thyGetOffersResponse.flightInformation.departureDate)
                .arrivalDate(thyGetOffersResponse.flightInformation.arrivalDate)
                .seatNumber(thyGetOffersResponse.flightInformation.seatNumber)
                .flightNumber(thyGetOffersResponse.flightInformation.flightNumber)
                .totalPrice(thyGetOffersResponse.offersPrice.price)
                .departureAirport(thyGetOffersResponse.getFlightInformation().departureAirport)
                .arrivalAirport(thyGetOffersResponse.flightInformation.arrivalAirport)
                .arrivalDate(thyGetOffersResponse.flightInformation.arrivalDate).build();
    }
}
