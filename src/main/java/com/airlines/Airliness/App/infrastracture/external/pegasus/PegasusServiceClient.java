package com.airlines.Airliness.App.infrastracture.external.pegasus;


import com.airlines.Airliness.App.infrastracture.external.pegasus.request.PegasusGetOffersRequest;
import com.airlines.Airliness.App.infrastracture.external.pegasus.response.PegasusGetOffersFlightInformation;
import com.airlines.Airliness.App.infrastracture.external.pegasus.response.PegasusGetOffersPrice;
import com.airlines.Airliness.App.infrastracture.external.pegasus.response.PegasusGetOffersResponse;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Date;

@Component
public class PegasusServiceClient {

    public PegasusGetOffersResponse getOffers(PegasusGetOffersRequest pegasusGetOffersRequest) {

        return new PegasusGetOffersResponse(
                new PegasusGetOffersPrice("USD", BigDecimal.TEN),
                new PegasusGetOffersFlightInformation("IST", "ESB", new Date(), new Date(), 123L, 1)
        );
    }

    public PegasusGetOffersResponse getOfferDetail(PegasusGetOffersRequest pegasusGetOffersRequest) {

        return new PegasusGetOffersResponse(
                new PegasusGetOffersPrice("USD", BigDecimal.TEN),
                new PegasusGetOffersFlightInformation("IST", "ESB", new Date(), new Date(), 123L, 1)
        );
        //TODO implement MocKoon
    }
}
