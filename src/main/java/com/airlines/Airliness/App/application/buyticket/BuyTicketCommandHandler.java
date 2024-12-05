package com.airlines.Airliness.App.application.buyticket;


import com.airlines.Airliness.App.application.buyticket.fragment.User;
import com.airlines.Airliness.App.domain.model.OfferInDetails;
import com.airlines.Airliness.App.service.GetOffersService;
import com.airlines.Airliness.App.service.SeatReservationService;
import org.springframework.stereotype.Component;

@Component
public class BuyTicketCommandHandler {
    public final GetOffersService offersService;
    public final SeatReservationService seatReservationService;

    public BuyTicketCommandHandler(GetOffersService offersService, SeatReservationService seatReservationService) {
        this.offersService = offersService;
        this.seatReservationService = seatReservationService;
    }


    public void handle(BuyTicketCommand command) {
        User user = command.getUser();
        if (user == null || user.getEmail() == null || user.getPassportNumber().isEmpty() || user.getSurname().isEmpty() || user.getName().isEmpty()) {
            throw new IllegalArgumentException("Valid user information is required.");
        }

        OfferInDetails selectedOffer = offersService.getOffersInDetail(command);
        if (selectedOffer == null) {
            throw new IllegalStateException("Selected offer is not valid or no longer available.");
        }

        // Rezervasyon Oluşturma
        seatReservationService.reserveSeat(
                selectedOffer.getFlightNumber(),
                selectedOffer.getAirlineName(),
                selectedOffer.getDepartureDate(),
                selectedOffer.getSeatClass(),
                selectedOffer.getSeatNumber(),
                selectedOffer.getPassenger()
        );
    }

}
