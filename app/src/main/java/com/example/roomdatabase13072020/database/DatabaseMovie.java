package com.example.roomdatabase13072020.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.roomdatabase13072020.database.dao.MovieDao;
import com.example.roomdatabase13072020.model.entities.MovieEntity;

@Database(entities = {MovieEntity.class}, version = 1)
public abstract class DatabaseMovie extends RoomDatabase {
    public abstract MovieDao movieDao();

    private static DatabaseMovie instance = null;

    public synchronized static DatabaseMovie getDatabase(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(
                    context,
                    DatabaseMovie.class,
                    "database-movie"
            ).build();
        }
        return instance;
    }
}
