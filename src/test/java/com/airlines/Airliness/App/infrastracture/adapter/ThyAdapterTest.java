package com.airlines.Airliness.App.infrastracture.adapter;

import com.airlines.Airliness.App.domain.model.Offer;
import com.airlines.Airliness.App.domain.model.OfferFilter;
import com.airlines.Airliness.App.infrastracture.external.pegasus.request.PegasusGetOffersRequest;
import com.airlines.Airliness.App.infrastracture.external.pegasus.response.PegasusGetOffersFlightInformation;
import com.airlines.Airliness.App.infrastracture.external.pegasus.response.PegasusGetOffersPrice;
import com.airlines.Airliness.App.infrastracture.external.pegasus.response.PegasusGetOffersResponse;
import com.airlines.Airliness.App.infrastracture.external.turkishairliness.ThyServiceClient;
import com.airlines.Airliness.App.infrastracture.external.turkishairliness.request.ThyGetOffersRequest;
import com.airlines.Airliness.App.infrastracture.external.turkishairliness.response.ThyGetFlightInformation;
import com.airlines.Airliness.App.infrastracture.external.turkishairliness.response.ThyGetOffersPrice;
import com.airlines.Airliness.App.infrastracture.external.turkishairliness.response.ThyGetOffersResponse;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ThyAdapterTest {

    @InjectMocks
    ThyAdapter thyAdapter;

    @Mock
    ThyServiceClient thyServiceClient;

    @Test
    void should_get_Offer() {
        //Given
        OfferFilter offerFilter = OfferFilter.builder()
                .departureAirport("IST")
                .arrivalAirport("SAM")
                .departureDate(new Date())
                .returnDate(new Date())
                .build();

        ThyGetFlightInformation thyGetFlightInformation = ThyGetFlightInformation.builder()
                .departureAirport("IST")
                .arrivalAirport("SAM")
                .departureDate(new Date())
                .arrivalDate(new Date())
                .flightNumber(1L)
                .seatNumber(1)
                .build();

        ThyGetOffersPrice thyGetOffersPrice = ThyGetOffersPrice.builder()
                .price(BigDecimal.TEN)
                .currency("TRY")
                .build();

        ThyGetOffersResponse thyGetOffersResponse = ThyGetOffersResponse.builder()
                .offersPrice(thyGetOffersPrice)
                .flightInformation(thyGetFlightInformation)
                .build();

        when(thyServiceClient.getOffers(any(ThyGetOffersRequest.class))).thenReturn(thyGetOffersResponse);

        //When
        Offer offer = thyAdapter.getOffer(offerFilter);

        //Then
        assertEquals(thyGetOffersResponse.offersPrice.price,offer.totalPrice);
        assertEquals(thyGetOffersResponse.offersPrice.currency,offer.currency);
        assertEquals(thyGetOffersResponse.flightInformation.departureAirport,offer.departureAirport);
        assertEquals(thyGetOffersResponse.flightInformation.flightNumber,offer.flightNumber);
        assertEquals(thyGetOffersResponse.flightInformation.arrivalAirport,offer.arrivalAirport);
        assertEquals(thyGetOffersResponse.flightInformation.departureDate,offer.departureDate);
        assertEquals(thyGetOffersResponse.flightInformation.arrivalDate,offer.arrivalDate);
        assertEquals(thyGetOffersResponse.flightInformation.seatNumber,offer.seatNumber);

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

        when(thyServiceClient.getOffers(any(ThyGetOffersRequest.class))).thenReturn(null);

        // When
        Offer offer = thyAdapter.getOffer(offerFilter);

        // Then
        assertNull(offer);
    }
}