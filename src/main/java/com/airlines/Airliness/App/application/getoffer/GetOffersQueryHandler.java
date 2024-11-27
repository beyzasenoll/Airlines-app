package com.airlines.Airliness.App.application.getoffer;

import com.airlines.Airliness.App.domain.model.Offer;
import com.airlines.Airliness.App.domain.model.OfferFilter;
import com.airlines.Airliness.App.domain.port.OfferPort;

import java.util.List;
import java.util.stream.Collectors;

public class GetOffersQueryHandler {
    private List<OfferPort> offerPortList;

    public GetOffersQueryHandler(List<OfferPort> offerPortList) {
        this.offerPortList = offerPortList;
    }

    public GetOffersQueryResponse handle(GetOffersQuery getOffersQuery) {

        OfferFilter offerFilter = createOfferFilter(getOffersQuery);
        List<Offer> offers=getOffersFromPorts(offerFilter);

        GetOffersQueryResponse getOffersQueryResponse = new GetOffersQueryResponse();
        getOffersQueryResponse.setOfferList(offers);

        return  getOffersQueryResponse;
    }

    private OfferFilter createOfferFilter(GetOffersQuery getOffersQuery) {
        return OfferFilter.builder()
                .departureAirport(getOffersQuery.getDepartureAirport())
                .arrivalAirport(getOffersQuery.getArrivalAirport())
                .departureDate(getOffersQuery.getDepartureDate())
                .returnDate(getOffersQuery.getReturnDate())
                .build();
    }
    private List<Offer> getOffersFromPorts(OfferFilter offerFilter) {
        return offerPortList.stream()
                .map(offerPort -> offerPort.getOffer(offerFilter))
                .filter(offer -> offer != null)
                .collect(Collectors.toList());
    }
}
