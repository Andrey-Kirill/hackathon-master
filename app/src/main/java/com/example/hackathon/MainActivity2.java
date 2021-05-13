package com.example.hackathon;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.Date;
import java.util.ArrayList;
import java.util.List;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        ListView listView = (ListView) findViewById(R.id.listview);
        ArrayList<Event> list = new ArrayList<>(0);
        list.add(new Event("Приключения Гуливера", "приключение", R.drawable.down, new Date(), new Date(), 100, 50));
//        list.add(new Event(, "Приключения Гуливера", R.drawable.down));
        Adapter adapter = new Adapter(this, R.layout.eventlayout, list);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Toast.makeText(getApplicationContext(), "Ты Негр №"+position, Toast.LENGTH_SHORT).show();
            }
        });
    }
}