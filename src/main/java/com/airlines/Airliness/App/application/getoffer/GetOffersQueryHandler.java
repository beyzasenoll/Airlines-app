package com.airlines.Airliness.App.application.getoffer;

import com.airlines.Airliness.App.domain.port.OfferPort;

import java.util.List;

public class GetOffersQueryHandler {
    private List<OfferPort> offerPortList;

    public GetOffersQueryHandler(List<OfferPort> offerPortList) {
        this.offerPortList = offerPortList;
    }

    public GetOffersQueryResponse handle(GetOffersQuery getOffersQuery) {
        //offerPortList.stream().map(offerPort -> {
        //    offerPort.getOffer()
        //});
    }
}
