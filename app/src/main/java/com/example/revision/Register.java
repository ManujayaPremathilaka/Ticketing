package com.example.revision;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import database.DBHelper;

public class Register extends AppCompatActivity {

    EditText username, password;
    CheckBox teacher, student;
    DBHelper dbHelper = new DBHelper(this);
    String type;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        username = findViewById(R.id.regUserName);
        password = findViewById(R.id.regPassword);
        teacher = findViewById(R.id.chkTeacher);
        student = findViewById(R.id.chkStudent);

        if (teacher.isChecked()){
            type = "teacher";
        }
        else if(student.isChecked()){
            type = "student";
        }
    }

    public void onBtnClick(View view){
       long result =  dbHelper.addUser(username.getText().toString().trim(), password.getText().toString().trim(), type);

       if (result > 0){
           Toast.makeText(getApplicationContext(), "Register Success", Toast.LENGTH_SHORT).show();
       }
       else{
           Toast.makeText(getApplicationContext(), "Register Unsuccess", Toast.LENGTH_SHORT).show();
       }

       Intent intent = new Intent(Register.this, MainActivity.class);
       startActivity(intent);
    }
}
