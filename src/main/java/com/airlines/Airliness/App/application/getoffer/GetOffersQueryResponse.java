package com.airlines.Airliness.App.application.getoffer;

import com.airlines.Airliness.App.domain.model.Offer;
import lombok.Data;

import java.util.List;

@Data
public class GetOffersQueryResponse {
    List<Offer> offerList;
}
