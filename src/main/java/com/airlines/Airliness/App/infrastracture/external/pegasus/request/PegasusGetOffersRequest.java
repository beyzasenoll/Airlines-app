package com.airlines.Airliness.App.infrastracture.external.pegasus.request;

import com.airlines.Airliness.App.domain.model.OfferFilter;
import com.airlines.Airliness.App.dto.DestinationDto;
import lombok.AllArgsConstructor;
import lombok.Builder;

import java.util.Date;

@Builder
@AllArgsConstructor
public class PegasusGetOffersRequest {
    public PegasusGetOffersDestinationDto destination;
    public Date departureDate;
    public Date returnDate;

}
