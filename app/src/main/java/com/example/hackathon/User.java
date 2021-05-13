package com.example.hackathon;

import android.os.Build;

import androidx.annotation.RequiresApi;

import java.util.Date;
import java.util.List;
import java.util.logging.StreamHandler;
import java.util.stream.Stream;

public class User {
    public String name;
    public String surname;

    private List<Ticket> tickets;
    private List<Ticket> expiredTickets;

    public User(String name,String surname){
        this.name = name;
        this.surname = surname;
    }

    public User(){

    }

    public void updateTicketExpiration() {
        final Date currentDate = new Date();
        tickets.removeIf((ticket -> {
            if (ticket.getEvent().getEndDate().before(currentDate)) {
                expiredTickets.add(ticket);
                return true;
            }
            return false;
        }));
    }
}
