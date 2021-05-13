package com.example.hackathon;

import java.util.Date;

public class Ticket {

    private Event event;
    private Date buyDate;

    public boolean isExpired() {
        Date currentDate = new Date();
        return buyDate.before(currentDate);
    }

    public Event getEvent() {
        return event;
    }

    public Date getBuyDate() {
        return buyDate;
    }


}
