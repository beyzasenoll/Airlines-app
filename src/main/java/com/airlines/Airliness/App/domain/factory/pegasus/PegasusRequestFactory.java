package com.airlines.Airliness.App.domain.factory.pegasus;

import com.airlines.Airliness.App.domain.model.OfferFilter;
import com.airlines.Airliness.App.infrastracture.external.pegasus.request.PegasusGetOffersDestinationDto;
import com.airlines.Airliness.App.infrastracture.external.pegasus.request.PegasusGetOffersRequest;

public class PegasusRequestFactory {
    public static PegasusGetOffersRequest fromOfferFilter(OfferFilter offerFilter) {
        return PegasusGetOffersRequest.builder()
                .destination(
                        PegasusGetOffersDestinationDto.builder()
                                .departureAirport(offerFilter.departureAirport)
                                .arrivalAirport(offerFilter.arrivalAirport)
                                .build()
                )
                .departureDate(offerFilter.departureDate)
                .returnDate(offerFilter.returnDate)
                .build();
    }

}
