package com.example.firebasetest;

import android.app.Application;

public class TestApplication extends Application {

    private UsersAccess usersAccess;

    @Override
    public void onCreate() {
        super.onCreate();
        usersAccess = new UsersAccess();
    }

    public UsersAccess getUsersAccess() {
        return usersAccess;
    }
}
