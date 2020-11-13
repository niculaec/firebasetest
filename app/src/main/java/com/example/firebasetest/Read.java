package com.example.firebasetest;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class Read extends AppCompatActivity {
    TextView name,pass;
    Button left, right;

    DatabaseReference dataref;
    ArrayList<Accounts> accountsList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read);

        name = findViewById(R.id.tv_name);
        pass = findViewById(R.id.tv_pass);
        left = findViewById(R.id.btn_left);
        right = findViewById(R.id.btn_right);

        dataref= FirebaseDatabase.getInstance().getReference("user");
        dataref.addListenerForSingleValueEvent(listener);

    }
    ValueEventListener listener = new ValueEventListener() {
        @Override
        public void onDataChange(@NonNull DataSnapshot snapshot) {
            for (DataSnapshot dss: snapshot.getChildren()) {
                Accounts peeps = dss.getValue(Accounts.class);
                accountsList.add(peeps);
            }
            name.setText(accountsList.get(1).getFn().toString());
            pass.setText(accountsList.get(1).getEmail().toString());
        }

        @Override
        public void onCancelled(@NonNull DatabaseError error) {

        }
    };
}