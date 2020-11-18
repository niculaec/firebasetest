package com.example.firebasetest;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.accounts.Account;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class Read extends AppCompatActivity {
    TextView name,email,pass;
    Button addUser;

    DatabaseReference dataref;
    //List<Accounts> Accounts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read);


        //findViews();
       // initListner();


    }
    private void findViews() {
        name = findViewById(R.id.editName);
        pass = findViewById(R.id.editPass);
        email = findViewById(R.id.editEmail);
        addUser = findViewById(R.id.addUser);

        dataref = FirebaseDatabase.getInstance().getReference("user");

        addUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Accounts acc = new Accounts(name.getText().toString(), email.getText().toString(), pass.getText().toString());
                dataref.child(dataref.push().getKey()).setValue(acc);
            }
        });

        //Accounts = new ArrayList<>();


    }


    //private void initListner() {
      //  addUser.setOnClickListener(new View.OnClickListener() {
        //    @Override
         //   public void onClick(View v) {
          //      addUser();
       //     }
      //  });



    }

   // private void addUser() {
        //getting the values to save
      //  String name =name.getText.toString().trim();
      //  String email = email.getText().toString().trim();
      //  String pass = pass.getText().toString().trim();

   // }


//}
