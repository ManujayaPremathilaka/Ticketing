package com.example.revision;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import database.DBHelper;

public class MainActivity extends AppCompatActivity {

    EditText userName, password;
    DBHelper dbHelper = new DBHelper(this);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        userName = findViewById(R.id.userName);
        password = findViewById(R.id.password);
    }

    public void onRegisterClick(View view){
        Intent intent = new Intent(MainActivity.this, Register.class);
        startActivity(intent);
    }

    public void onLoginClick(View view){
        String result = dbHelper.getUser(userName.getText().toString().trim(), password.getText().toString().trim());

        if (result == null){
            Toast.makeText(getApplicationContext(), "Invalid User", Toast.LENGTH_SHORT).show();
        }
        else {
            if (result.equalsIgnoreCase("student")){
                Intent intentStd = new Intent(MainActivity.this, Student.class);
                startActivity(intentStd);
            }
            else {
                Intent intentTchr = new Intent(MainActivity.this, Teacher.class);
                startActivity(intentTchr);
            }
        }
    }
}
