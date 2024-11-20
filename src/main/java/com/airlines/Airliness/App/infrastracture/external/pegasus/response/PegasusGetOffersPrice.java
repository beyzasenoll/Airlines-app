package com.airlines.Airliness.App.infrastracture.external.pegasus.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@Builder
public class PegasusGetOffersPrice {
    public String currency;
    public BigDecimal total;
}
