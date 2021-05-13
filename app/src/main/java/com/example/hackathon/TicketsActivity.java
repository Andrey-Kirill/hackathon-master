package com.example.hackathon;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

public class TicketsActivity extends AppCompatActivity {
    RecyclerView tickets;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tickets_activity);
        tickets = findViewById(R.id.tickets);

    }
}
