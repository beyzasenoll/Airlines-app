package com.airlines.Airliness.App.service;


import com.airlines.Airliness.App.application.buyticket.BuyTicketCommand;
import com.airlines.Airliness.App.domain.model.OfferInDetails;
import com.airlines.Airliness.App.dto.GetOffersRequest;
import com.airlines.Airliness.App.dto.GetOffersResponse;
import org.springframework.stereotype.Service;

@Service
public class GetOffersService {

    public GetOffersResponse getOffers(GetOffersRequest getOffersRequest) {
        //TODO not implemented yet
        return null;
    }

    public OfferInDetails getOffersInDetail(BuyTicketCommand command){

        if (command == null || command.getUser() == null) {
            throw new IllegalArgumentException("BuyTicketCommand or its user cannot be null.");
        }

        OfferInDetails offerInDetails = new OfferInDetails();
        if(command.user.getPassportNumber() == offerInDetails.getPassportNumber() && command.getSelectedFlightNumber().equals(offerInDetails.getFlightNumber())){
            return offerInDetails;
        }

        return null;
    }

}
