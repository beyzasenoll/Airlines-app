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

        Offer mockOffer1 = mock(Offer.class);
        Offer mockOffer2 = mock(Offer.class);

        when(pegasusAdapter.getOffer(Mockito.any(OfferFilter.class))).thenReturn(mockOffer1);
        when(thyAdapter.getOffer(Mockito.any(OfferFilter.class))).thenReturn(mockOffer2);


        List<OfferPort> offerPortList = Arrays.asList(pegasusAdapter, thyAdapter);
        GetOffersQueryHandler handler = new GetOffersQueryHandler(offerPortList);

        // When
        GetOffersQueryResponse response = handler.handle(getOffersQuery);

        // Then

        assertNotNull(response);
        assertEquals(2, response.getOfferList().size());
        assertTrue(response.getOfferList().contains(mockOffer1));
        assertTrue(response.getOfferList().contains(mockOffer2));
    }

    @Test
    void should_return_null(){
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