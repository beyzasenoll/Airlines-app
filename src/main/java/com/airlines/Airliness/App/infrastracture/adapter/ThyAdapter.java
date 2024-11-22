package com.airlines.Airliness.App.infrastracture.adapter;

import com.airlines.Airliness.App.domain.model.Offer;
import com.airlines.Airliness.App.domain.model.OfferFilter;
import com.airlines.Airliness.App.domain.port.OfferPort;
import com.airlines.Airliness.App.infrastracture.external.pegasus.request.PegasusGetOffersRequest;
import com.airlines.Airliness.App.infrastracture.external.pegasus.response.PegasusGetOffersResponse;
import com.airlines.Airliness.App.infrastracture.external.turkishairliness.ThyServiceClient;
import com.airlines.Airliness.App.infrastracture.external.turkishairliness.request.ThyGetOffersDestinationDto;
import com.airlines.Airliness.App.infrastracture.external.turkishairliness.request.ThyGetOffersRequest;
import com.airlines.Airliness.App.infrastracture.external.turkishairliness.response.ThyGetOffersPrice;
import com.airlines.Airliness.App.infrastracture.external.turkishairliness.response.ThyGetOffersResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ThyAdapter implements OfferPort {

    ThyServiceClient thyServiceClient;

    @Override
    public Offer getOffer(OfferFilter offerFilter) {

        ThyGetOffersRequest request = ThyGetOffersRequest.builder().build();
        request.destination = ThyGetOffersDestinationDto.builder().build();
        request.destination.departureAirport = offerFilter.departureAirport;
        request.destination.arrivalAirport = offerFilter.arrivalAirport;
        request.departureDate = offerFilter.departureDate;
        request.returnDate = offerFilter.returnDate;

        ThyGetOffersResponse thyGetOffersResponse = thyServiceClient.getOffers(request);

        return Offer.builder().currency(thyGetOffersResponse.offersPrice.currency)
                .departureDate(thyGetOffersResponse.flightInformation.departureDate)
                .arrivalDate(thyGetOffersResponse.flightInformation.arrivalDate)
                .seatNumber(thyGetOffersResponse.flightInformation.seatNumber)
                .flightNumber(thyGetOffersResponse.flightInformation.flightNumber)
                .totalPrice(thyGetOffersResponse.offersPrice.price)
                .departureAirport(thyGetOffersResponse.getFlightInformation().departureAirport)
                .arrivalAirport(thyGetOffersResponse.flightInformation.arrivalAirport)
                .arrivalDate(thyGetOffersResponse.flightInformation.arrivalDate).build();

        // offer.from()
     // TODO: not implemented yet
    }
}
