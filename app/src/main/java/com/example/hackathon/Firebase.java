package com.example.hackathon;

import com.google.firebase.database.FirebaseDatabase;

public class Firebase {
    public static void authenticate(User user, String id) {
        User.setUser(user);
        FirebaseDatabase.getInstance().getReference(id).setValue(user);
    }
}
