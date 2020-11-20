package com.example.firebasetest;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {
    Button createUserButton, readUserButton, updateUserButton;


    FirebaseAuth fauth;

    private DatabaseReference mDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        createUserButton = findViewById(R.id.createUserButton);
        readUserButton = findViewById(R.id.readUserButton);
        updateUserButton = findViewById(R.id.updateUserButton);

        fauth = FirebaseAuth.getInstance();

        mDatabase = FirebaseDatabase.getInstance().getReference();
    }

    public void createUser(View view) {
        UserProfile user = new UserProfile("Harcea Parcea", "parcea@hareca.com","hahaha");
        mDatabase.child("users").child(user.getId()).setValue(user);
        //                .addOnFailureListener(new OnFailureListener() {
//                    @Override
//                    public void onFailure(@NonNull Exception e) {
//                        Log.e(MainActivity.this.toString(),"failure",e);
//                    }
//                }).addOnCompleteListener(new OnCompleteListener<Void>() {
//                    @Override
//                    public void onComplete(@NonNull Task<Void> task) {
//                        if(task.isCanceled()){
//                            Log.d("","");
//                        }
//                        if(task.isComplete()){
//                            Log.d("","");
//                        }
//                        if(task.isSuccessful()){
//                            Log.d("","");
//                        }
//                    }
//                });

    }

    public void writeMessage(){

        // Write a message to the database
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("message");

        myRef.setValue("Hello, World!");
    }

    public void readUser(View view) {

        mDatabase.child("users").child("parcea@harecacom").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                UserProfile userProfile = snapshot.getValue(UserProfile.class);
               Log.d("ceva",userProfile.toString());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    public void updateUser(View view) {
        mDatabase.child("users").child("parcea@harecacom").child("email").setValue("altemail@undomeniu.com");
    }
}