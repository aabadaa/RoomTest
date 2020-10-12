package com.abada.roomtest;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {Test.class}, version = 1, exportSchema = false)
public abstract class MyRoom extends RoomDatabase {
    public final static ExecutorService executer = Executors.newFixedThreadPool(4);
    private static MyRoom instance;

    public static MyRoom getInstance(Context context) {
        if (instance == null)
            synchronized (MyRoom.class) {
                instance = Room.databaseBuilder(context, MyRoom.class, "tests").build();
            }
        return instance;
    }

    public abstract TestDao getDao();

    @Override
    public void close() {
        super.close();
        instance = null;
    }
}
