package com.airlines.Airliness.App.infrastracture.external.turkishairliness;

import com.airlines.Airliness.App.infrastracture.external.turkishairliness.request.ThyGetOffersRequest;
import com.airlines.Airliness.App.infrastracture.external.turkishairliness.response.ThyGetFlightInformation;
import com.airlines.Airliness.App.infrastracture.external.turkishairliness.response.ThyGetOffersPrice;
import com.airlines.Airliness.App.infrastracture.external.turkishairliness.response.ThyGetOffersResponse;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Date;

@Component
public class ThyServiceClient {
    public ThyGetOffersResponse getOffers(ThyGetOffersRequest thyGetOffersRequest) {

        return new ThyGetOffersResponse(
                new ThyGetOffersPrice("USD", BigDecimal.TEN),
                new ThyGetFlightInformation("IST", "ESB", new Date(), new Date(), 123L, 1)
        );
        //TODO implement MocKoon
    }
}
