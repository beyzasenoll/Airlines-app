package com.airlines.Airliness.App.infrastracture.adapter;

import com.airlines.Airliness.App.domain.model.Offer;
import com.airlines.Airliness.App.domain.model.OfferFilter;
import com.airlines.Airliness.App.infrastracture.external.pegasus.PegasusServiceClient;
import com.airlines.Airliness.App.infrastracture.external.pegasus.request.PegasusGetOffersDestinationDto;
import com.airlines.Airliness.App.infrastracture.external.pegasus.request.PegasusGetOffersRequest;
import com.airlines.Airliness.App.infrastracture.external.pegasus.response.PegasusGetOffersFlightInformation;
import com.airlines.Airliness.App.infrastracture.external.pegasus.response.PegasusGetOffersPrice;
import com.airlines.Airliness.App.infrastracture.external.pegasus.response.PegasusGetOffersResponse;
import com.airlines.Airliness.App.infrastracture.external.turkishairliness.request.ThyGetOffersRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;


import java.math.BigDecimal;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class PegasusAdapterTest {

    @InjectMocks
    PegasusAdapter pegasusAdapter;

    @Mock
    PegasusServiceClient pegasusServiceClient;


    @Test
    void should_get_pegasus_offers() {
        // Given
        OfferFilter offerFilter = OfferFilter.builder()
                .departureAirport("IST")
                .arrivalAirport("SAM")
                .departureDate(new Date())
                .returnDate(new Date())
                .build();

        PegasusGetOffersFlightInformation pegasusGetOffersFlightInformation = PegasusGetOffersFlightInformation.builder()
                .departureAirport("IST")
                .arrivalAirport("AYT")
                .departureDate(new Date())
                .arrivalDate(new Date())
                .flightNumber(1L)
                .seatNumber(1)
                .build();

        PegasusGetOffersPrice pegasusGetOffersPrice = PegasusGetOffersPrice.builder()
                .total(BigDecimal.TEN)
                .currency("TRY")
                .build();

        PegasusGetOffersResponse pegasusGetOffersResponse = PegasusGetOffersResponse.builder()
                .price(pegasusGetOffersPrice)
                .flightInformation(pegasusGetOffersFlightInformation)
                .build();

        when(pegasusServiceClient.getOffers(any(PegasusGetOffersRequest.class))).thenReturn(pegasusGetOffersResponse);

        // When
        Offer response = pegasusAdapter.getOffer(offerFilter);

        // Then
        assertEquals(pegasusGetOffersResponse.price.total, response.totalPrice);
        assertEquals(pegasusGetOffersResponse.price.currency, response.currency);
        assertEquals(pegasusGetOffersResponse.flightInformation.departureAirport, response.departureAirport);
    }

    @Test
    void when_offer_is_empty_should_return_null() {
        // Given
        OfferFilter offerFilter = OfferFilter.builder()
                .departureAirport("IST")
                .arrivalAirport("SAM")
                .departureDate(new Date())
                .returnDate(new Date())
                .build();

        when(pegasusServiceClient.getOffers(any(PegasusGetOffersRequest.class))).thenReturn(null);

        // When
        Offer offer = pegasusAdapter.getOffer(offerFilter);

        // Then
        assertNull(offer);
    }
}