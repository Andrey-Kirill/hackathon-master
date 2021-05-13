package com.example.hackathon;

import android.util.Log;
import android.widget.Toast;

import java.util.Date;

public class TicketSeller {

    public static boolean buyTicket(Event event) {
        User user = User.getCurrentUser();
        //-------------
        Date date = new Date();
        user.addTicket(new Ticket(event, date));
        Log.i("Ticket", String.format("Ticket to %s has bought by %s", event.getName(), user.getName()));
        //-------------
        return false;
    }

}
