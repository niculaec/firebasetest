package com.example.firebasetest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button createUserButton, readUserButton, updateUserButton;

    UsersAccess usersAccess;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        createUserButton = findViewById(R.id.createUserButton);
        readUserButton = findViewById(R.id.readUserButton);
        updateUserButton = findViewById(R.id.updateUserButton);
        usersAccess = UsersAccess.getInstance();
    }

    public void createUser(View view) {
        UserProfile user = new UserProfile("Harcea Parcea", "parcea@hareca.com","hahaha");
        usersAccess.create(user);
    }

    public void readUser(View view) {
        usersAccess.read("parcea@harecacom", new UsersAccess.ReadUserCallback() {
            @Override
            public void onReadSuccessful(UserProfile userProfile) {
                Log.d(MainActivity.this.getClass().getSimpleName(),userProfile.toString());
            }
        });
    }

    public void updateUser(View view) {
    }
}