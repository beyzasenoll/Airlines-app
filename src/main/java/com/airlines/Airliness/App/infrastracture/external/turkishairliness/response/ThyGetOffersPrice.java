package com.airlines.Airliness.App.infrastracture.external.turkishairliness.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import java.math.BigDecimal;

@Builder
@AllArgsConstructor
@Data
public class ThyGetOffersPrice {
    public String currency ;
    public BigDecimal price;
}
