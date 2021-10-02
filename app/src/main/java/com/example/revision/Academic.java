package com.example.revision;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class Academic extends AppCompatActivity {
        ListView listView;
         DBHelper dbHelper = new DBHelper(this);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher);
    }
}