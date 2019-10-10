package com.example.revision;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import database.DBHelper;

public class Message extends AppCompatActivity {

    TextView dispsubject, dispmessage;
    DBHelper dbHelper = new DBHelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message);

        String subject = getIntent().getStringExtra("subject");

        dispsubject = findViewById(R.id.dispSubject);
        dispmessage = findViewById(R.id.dispMessage);

        String message = dbHelper.getMessage(subject);

        dispsubject.setText(subject);
        dispmessage.setText(message);

    }
}
