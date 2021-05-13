package com.example.hackathon;

import java.util.Date;

public class Ticket {

    private Event event;
    private Date buyDate;
    private String ID;

    public Ticket(Event event, Date buyDate) {
        this.event = event;
        this.buyDate = buyDate;
        ID = UUID.randomUUID().toString();
    }

    public boolean isExpired() {
        Date currentDate = new Date();
        return buyDate.before(currentDate);
    }

    @Override
    public boolean equals(@Nullable Object obj) {
        if (obj == null || getClass() != obj.getClass())
            return false;
        return ID.equals(((Ticket) obj).ID);
    }

    public Event getEvent() {
        return event;
    }

    public Date getBuyDate() {
        return buyDate;
    }

    public String getID() {
        return ID;
    }
}
