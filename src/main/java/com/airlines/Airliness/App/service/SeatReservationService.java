package com.airlines.Airliness.App.service;

import com.airlines.Airliness.App.domain.model.fragment.Passenger;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class SeatReservationService {

    private final Map<String, String> reservations = new HashMap<>();
    public boolean checkSeatAvailability(Long flightNumber,String airline, Date date, String seatClass ,Integer seat) {
        String key = generateKey(flightNumber,airline, date, seatClass ,seat);
        return !reservations.containsKey(key);
    }

    public void reserveSeat(Long flightNumber, String airline, Date date, String seatClass, Integer seat, Passenger passenger) {
        String key = generateKey(flightNumber,airline, date, seatClass,seat);

        if (!checkSeatAvailability(flightNumber,airline, date,seatClass, seat)) {
            throw new IllegalStateException("Seat " + seat + " is already reserved.");
        }

        reservations.put(key, passenger.getEmail());
        System.out.println("Seat " + seat + " reserved successfully for " + passenger.getName() + " " + passenger.getSurname());
    }

    private String generateKey(Long flightNumber, String airline, Date date, String seatClass, Integer seat) {
        return flightNumber +"_"+ airline + "_" + date +"_"+ seatClass + "_" + seat;
    }
}
