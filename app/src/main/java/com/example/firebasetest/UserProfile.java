package com.example.firebasetest;

import com.google.firebase.database.Exclude;

import java.util.HashMap;
import java.util.Map;

public class UserProfile {

    public String fullName, email, password;


    public UserProfile(String fullName, String email, String password) {
        this.fullName = fullName;
        this.email = email;
        this.password = password;
    }

    @Exclude
    public String getId(){
        return  email.replace(".","");
    }

    @Exclude
    public Map<String, Object> toMap() {
        HashMap<String, Object> result = new HashMap<>();
        result.put("fullName", fullName);
        result.put("email", email);
        result.put("password", password);
        return result;
    }

    public UserProfile() { }
}
