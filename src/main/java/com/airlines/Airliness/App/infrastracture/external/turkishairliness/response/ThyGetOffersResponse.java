package com.airlines.Airliness.App.infrastracture.external.turkishairliness.response;

import com.airlines.Airliness.App.domain.model.Offer;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Builder
@AllArgsConstructor
@Data
public class ThyGetOffersResponse {
    public ThyGetOffersPrice offersPrice;
    public ThyGetFlightInformation flightInformation;

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
