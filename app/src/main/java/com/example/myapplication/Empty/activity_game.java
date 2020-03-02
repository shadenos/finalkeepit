package com.example.myapplication.Empty;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.myapplication.R;
import com.google.android.material.tabs.TabLayout;

public class activity_game extends AppCompatActivity {

    Toolbar toolbar;
    TabLayout tapLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

//        tapLayout = (TabLayout) findViewById(R.id.taplayout);
//        tapLayout.addTab(tapLayout.newTab().setText("Tap 1"));
//        tapLayout.addTab(tapLayout.newTab().setText("Tap 2"));

        //For tool bar
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

}
