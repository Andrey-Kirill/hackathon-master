package com.example.hackathon;

import java.util.List;

public class User {
    public String name;
    public String surname;
    List<Ticket> tickets;

    public User(String name,String surname){
        this.name = name;
        this.surname = surname;
    }
    public User(){}
}
