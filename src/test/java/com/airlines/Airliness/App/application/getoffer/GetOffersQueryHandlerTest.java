package com.airlines.Airliness.App.application.getoffer;

import com.airlines.Airliness.App.domain.model.Offer;
import com.airlines.Airliness.App.domain.model.OfferFilter;
import com.airlines.Airliness.App.domain.port.OfferPort;
import com.airlines.Airliness.App.infrastracture.adapter.PegasusAdapter;
import com.airlines.Airliness.App.infrastracture.adapter.ThyAdapter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class GetOffersQueryHandlerTest {

    @InjectMocks
    GetOffersQueryHandler getOffersQueryHandler;

    @Mock
    ThyAdapter thyAdapter;

    @Mock
    PegasusAdapter pegasusAdapter;

    @BeforeEach
    void setUp() {
        getOffersQueryHandler = new GetOffersQueryHandler(List.of(thyAdapter, pegasusAdapter));
    }


    @Test
    void should_get_offers() {
        // Given
        GetOffersQuery getOffersQuery = new GetOffersQuery();
        getOffersQuery.arrivalAirport = "arrivalAirport";
        getOffersQuery.departureAirport = "departureAirport";
        getOffersQuery.departureDate = new java.util.Date(1L);
        getOffersQuery.returnDate = new java.util.Date(1L);


        Offer mockOffer = new Offer(BigDecimal.TEN, "TL", "departureAirport", "arrivalAirport", new java.util.Date(1L), new java.util.Date(1L), 1L, 1);
        Offer mockOffer2 = new Offer(BigDecimal.ONE, "USD", "departureAirport2", "arrivalAirport2", new java.util.Date(1L), new java.util.Date(1L), 1L, 1);

        when(pegasusAdapter.getOffer(Mockito.any(OfferFilter.class))).thenReturn(mockOffer);
        when(thyAdapter.getOffer(Mockito.any(OfferFilter.class))).thenReturn(mockOffer2);


        List<OfferPort> offerPortList = Arrays.asList(pegasusAdapter, thyAdapter);
        GetOffersQueryHandler handler = new GetOffersQueryHandler(offerPortList);

        // When
        GetOffersQueryResponse response = handler.handle(getOffersQuery);

        // Then

        assertNotNull(response);
        assertEquals(2, response.getOfferList().size());
        assertTrue(response.getOfferList().contains(mockOffer));
        assertTrue(response.getOfferList().contains(mockOffer2));

        // Then mock offer fields
        assertEquals(mockOffer.totalPrice, response.getOfferList().get(0).totalPrice);
        assertEquals(mockOffer.currency, response.getOfferList().get(0).currency);
        assertEquals(mockOffer.departureAirport, response.getOfferList().get(0).departureAirport);
        assertEquals(mockOffer.arrivalAirport, response.getOfferList().get(0).arrivalAirport);
        assertEquals(mockOffer.departureDate, response.getOfferList().get(0).departureDate);
        assertEquals(mockOffer.arrivalDate, response.getOfferList().get(0).arrivalDate);
        assertEquals(mockOffer.flightNumber, response.getOfferList().get(0).flightNumber);
        assertEquals(mockOffer.seatNumber, response.getOfferList().get(0).seatNumber);

        // Then mock offer 2 fields
        assertEquals(mockOffer2.totalPrice, response.getOfferList().get(1).totalPrice);
        assertEquals(mockOffer2.currency, response.getOfferList().get(1).currency);
        assertEquals(mockOffer2.departureAirport, response.getOfferList().get(1).departureAirport);
        assertEquals(mockOffer2.arrivalAirport, response.getOfferList().get(1).arrivalAirport);
        assertEquals(mockOffer2.departureDate, response.getOfferList().get(1).departureDate);
        assertEquals(mockOffer2.arrivalDate, response.getOfferList().get(1).arrivalDate);
        assertEquals(mockOffer2.flightNumber, response.getOfferList().get(1).flightNumber);
        assertEquals(mockOffer2.seatNumber, response.getOfferList().get(1).seatNumber);
    }

    @Test
    void should_return_null() {
        // Given
        GetOffersQuery getOffersQuery = new GetOffersQuery();
        getOffersQuery.arrivalAirport = "arrivalAirport";
        getOffersQuery.departureAirport = "departureAirport";
        getOffersQuery.departureDate = new java.util.Date(1L);
        getOffersQuery.returnDate = new java.util.Date(1L);


        when(pegasusAdapter.getOffer(Mockito.any(OfferFilter.class))).thenReturn(null);
        when(thyAdapter.getOffer(Mockito.any(OfferFilter.class))).thenReturn(null);

        List<OfferPort> offerPortList = Arrays.asList(pegasusAdapter, thyAdapter);
        GetOffersQueryHandler handler = new GetOffersQueryHandler(offerPortList);

        // When
        GetOffersQueryResponse response = handler.handle(getOffersQuery);

        // Then
        assertNotNull(response);
        assertTrue(response.getOfferList().isEmpty());

    }
}