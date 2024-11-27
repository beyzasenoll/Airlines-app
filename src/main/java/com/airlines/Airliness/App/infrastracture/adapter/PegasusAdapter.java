package com.airlines.Airliness.App.infrastracture.adapter;

import com.airlines.Airliness.App.domain.model.Offer;
import com.airlines.Airliness.App.domain.model.OfferFilter;
import com.airlines.Airliness.App.domain.port.OfferPort;
import com.airlines.Airliness.App.infrastracture.external.pegasus.PegasusServiceClient;
import com.airlines.Airliness.App.infrastracture.external.pegasus.request.PegasusGetOffersRequest;
import com.airlines.Airliness.App.infrastracture.external.pegasus.response.PegasusGetOffersResponse;
import org.springframework.stereotype.Component;

@Component
public class PegasusAdapter implements OfferPort {

    private final PegasusServiceClient pegasusServiceClient;
    public PegasusAdapter(PegasusServiceClient pegasusServiceClient) {
        this.pegasusServiceClient = pegasusServiceClient;

    }

    @Override
    public Offer getOffer(OfferFilter offerFilter) {

        PegasusGetOffersRequest pegasusGetOffersRequest = PegasusGetOffersRequest.fromOfferFilter(offerFilter);

        PegasusGetOffersResponse pegasusGetOffersResponse = pegasusServiceClient.getOffers(pegasusGetOffersRequest);
        if (pegasusGetOffersResponse == null || pegasusGetOffersResponse.flightInformation == null || pegasusGetOffersResponse.price == null){
            return null;
        }

        return PegasusGetOffersResponse.fromPegasusGetOffersResponse(pegasusGetOffersResponse);
    }
}
