package com.example.firebasetest;

public class Accounts {
    String fn,email,password;

    public Accounts(String fn, String email, String password) {
        this.fn = fn;
        this.email = email;
        this.password = password;
    }

    public Accounts() {
    }

    public String getFn() {
        return fn;
    }

    public void setFn(String fn) {
        this.fn = fn;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
