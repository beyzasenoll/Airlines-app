package com.airlines.Airliness.App.infrastracture.adapter;

import com.airlines.Airliness.App.domain.model.Offer;
import com.airlines.Airliness.App.domain.model.OfferFilter;
import com.airlines.Airliness.App.domain.port.OfferPort;

import com.airlines.Airliness.App.infrastracture.external.turkishairliness.ThyServiceClient;
import com.airlines.Airliness.App.infrastracture.external.turkishairliness.request.ThyGetOffersRequest;
import com.airlines.Airliness.App.infrastracture.external.turkishairliness.response.ThyGetOffersResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ThyAdapter implements OfferPort {

    @Autowired
    public ThyServiceClient thyServiceClient;


    @Override
    public Offer getOffer(OfferFilter offerFilter) {

        ThyGetOffersRequest request = ThyGetOffersRequest.fromOfferFilter(offerFilter);

        ThyGetOffersResponse thyGetOffersResponse = thyServiceClient.getOffers(request);
        Offer offer = ThyGetOffersResponse.fromOfferResponse(thyGetOffersResponse);
        return offer;

        // offer.from()
     // TODO: not implemented yet
    }
}
