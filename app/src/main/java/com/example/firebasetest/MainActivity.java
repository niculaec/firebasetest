package com.example.firebasetest;

import androidx.appcompat.app.AppCompatActivity;

import android.accounts.Account;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    EditText fn, email, password;
    Button register;
    TextView login;

    FirebaseAuth fauth;
    DatabaseReference dataref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fn = findViewById(R.id.fn_field);
        email = findViewById(R.id.email_field);
        register = findViewById(R.id.register_btn);
        password = findViewById(R.id.password_field);
        login = findViewById(R.id.take_login);

        dataref = FirebaseDatabase.getInstance().getReference("person");
        fauth = FirebaseAuth.getInstance();

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Accounts acc = new Accounts(fn.getText().toString(), email.getText().toString(), password.getText().toString());
                dataref.child(dataref.push().getKey()).setValue(acc);

            }
        });
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), Login.class));
            }
        });
    }
}