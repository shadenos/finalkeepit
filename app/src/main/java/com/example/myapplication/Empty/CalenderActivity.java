package com.example.myapplication.Empty;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.myapplication.Adaptors.calendarAdapter;
import com.example.myapplication.R;

import java.util.ArrayList;

public class CalenderActivity extends AppCompatActivity {

    ArrayList<String> namslist;
    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    calendarAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calender);

        recyclerView = (RecyclerView)findViewById(R.id.recycler_calendar);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);

        namslist=new ArrayList<>();
    }
}
