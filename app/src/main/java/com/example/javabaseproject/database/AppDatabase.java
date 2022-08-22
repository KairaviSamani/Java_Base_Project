package com.example.javabaseproject.database;

import android.content.Context;

import androidx.room.Room;
import androidx.room.RoomDatabase;

abstract class AppDatabase extends RoomDatabase {
    private AppDatabase appDatabase = null;

    abstract UserDao userDao();

    public AppDatabase getInstance(Context context) {
        if (appDatabase == null) {
            appDatabase = Room.databaseBuilder(
                    context.getApplicationContext(),
                    AppDatabase.class,
                    "database-name"
            ).build();
        }
        return appDatabase;
    }
}
