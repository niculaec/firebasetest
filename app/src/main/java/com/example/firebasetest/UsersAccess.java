package com.example.firebasetest;

import android.util.Log;
import android.view.View;

import androidx.annotation.NonNull;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class UsersAccess {

    private DatabaseReference mDatabase;
    private DatabaseReference users;

    public UsersAccess(){
        mDatabase = FirebaseDatabase.getInstance().getReference();
        users = mDatabase.child("users");
    }

    public void create(UserProfile user) {
        users.child(user.getId()).setValue(user);
    }

    public void read(String id, ReadUserCallback readUserCallback){
        users.child(id).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                UserProfile userProfile = snapshot.getValue(UserProfile.class);
                readUserCallback.onReadSuccessful(userProfile);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    public interface ReadUserCallback{

        void onReadSuccessful(UserProfile userProfile);
    }
}
