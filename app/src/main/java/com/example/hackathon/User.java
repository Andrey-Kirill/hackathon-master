package com.example.hackathon;

import android.os.Build;

import androidx.annotation.RequiresApi;

import java.util.Date;
import java.util.List;
import java.util.logging.StreamHandler;
import java.util.stream.Stream;

public class User {
    private String name;
    private String surname;

    private List<Ticket> tickets;
    private List<Event> favourites;

    private static User user;

    public User() {

    }

    public User(String name,String surname) {
        this.name = name;
        this.surname = surname;
    }

    public static void setUser(String name, String surname) {
        user = new User(name, surname);
    }

    public User(String name, String surname, List<Ticket> tickets, List<Event> favourites) {
        this.name = name;
        this.surname = surname;
        this.tickets = tickets;
        this.favourites = favourites;
    }

    public static void setUser(String name, String surname, List<Ticket> tickets, List<Event> favourites) {
        user = new User(name, surname, tickets, favourites);
    }

    public static void setUser(User user) {
        User.user = user;
    }

    public static User getCurrentUser() {
        return user;
    }

    public void addTicket(Ticket ticket) {
        tickets.add(ticket);
    }

    public void addEventToFavourite(Event event) {
        if (!favourites.contains(event))
            favourites.add(event);
    }

    public boolean isEventIsFavourite(Event event) {
        return favourites.contains(event);
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public List<Ticket> getTickets() {
        return tickets;
    }

    public List<Event> getFavourites() {
        return favourites;
    }
}
