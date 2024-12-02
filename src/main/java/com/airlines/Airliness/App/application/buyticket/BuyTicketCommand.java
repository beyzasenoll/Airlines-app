package com.airlines.Airliness.App.application.buyticket;

import com.airlines.Airliness.App.application.buyticket.fragment.User;
import lombok.Data;

@Data
public class BuyTicketCommand {
    public User user;
    public String selectedAirline;
    public String selectedDate;
    public String selectedTime;
    public String selectedSeat;
}
