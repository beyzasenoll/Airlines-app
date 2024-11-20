package com.airlines.Airliness.App.domain.port;

import com.airlines.Airliness.App.domain.model.Offer;
import com.airlines.Airliness.App.domain.model.OfferFilter;

public interface OfferPort {
    public Offer getOffer(OfferFilter offerFilter);
}
