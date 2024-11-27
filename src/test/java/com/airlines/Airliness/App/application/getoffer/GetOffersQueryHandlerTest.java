package com.airlines.Airliness.App.application.getoffer;

import com.airlines.Airliness.App.infrastracture.adapter.PegasusAdapter;
import com.airlines.Airliness.App.infrastracture.adapter.ThyAdapter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

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

        // When
        getOffersQueryHandler.handle(getOffersQuery);

        // Then
    }
}