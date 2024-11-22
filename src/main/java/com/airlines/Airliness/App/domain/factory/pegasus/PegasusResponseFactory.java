package com.airlines.Airliness.App.domain.factory.pegasus;

import com.airlines.Airliness.App.domain.model.Offer;
import com.airlines.Airliness.App.infrastracture.external.pegasus.response.PegasusGetOffersResponse;

public class PegasusResponseFactory {

    public static Offer fromPegasusGetOffersResponse(PegasusGetOffersResponse pegasusGetOffersResponse) {
                return Offer.builder()
                        .totalPrice(pegasusGetOffersResponse.price.total)
                        .currency(pegasusGetOffersResponse.price.currency)
                        .departureAirport(pegasusGetOffersResponse.flightInformation.departureAirport)
                        .arrivalAirport(pegasusGetOffersResponse.flightInformation.arrivalAirport)
                        .departureDate(pegasusGetOffersResponse.flightInformation.departureDate)
                        .arrivalDate(pegasusGetOffersResponse.flightInformation.arrivalDate)
                        .flightNumber(pegasusGetOffersResponse.flightInformation.flightNumber)
                        .seatNumber(pegasusGetOffersResponse.flightInformation.seatNumber)
                .build();
    }
}
