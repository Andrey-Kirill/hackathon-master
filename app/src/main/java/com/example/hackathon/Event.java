package com.example.hackathon;

import android.graphics.Bitmap;

import androidx.annotation.Nullable;

import java.util.Date;

public class Event {

    private String date;
    private String name;
    private String description;
    private Bitmap photo;

    private Date startDate;
    private Date endDate;

    private int cost;
    private int seatsLeft;
    private int seats;

    public Event(String date, String name, String description, Bitmap photo, Date startDate, Date endDate, int cost, int seats) {
        this.date = date;
        this.name = name;
        this.description = description;
        this.photo = photo;
        this.startDate = startDate;
        this.endDate = endDate;
        this.cost = cost;
        this.seats = seats;
        this.seatsLeft = seats;
    }

    @Override
    public boolean equals(@Nullable Object obj) {
        if (obj == null || getClass() != obj.getClass())
            return false;
        return name.equals(((Event) obj).name);
    }

    public String getDate() {
        return date;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Bitmap getPhoto() {
        return photo;
    }

    public Date getStartDate() {
        return startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public int getCost() {
        return cost;
    }

    public int getSeatsLeft() {
        return seatsLeft;
    }

    public int getSeats() {
        return seats;
    }

    public void setSeatsLeft(int seatsLeft) {
        this.seatsLeft = seatsLeft;
    }
}
