package com.example.roomdatabase13072020.database.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.example.roomdatabase13072020.model.entities.MovieEntity;

import java.util.List;

import io.reactivex.Maybe;

@Dao
public interface MovieDao {
    @Query("SELECT * FROM Movie")
    Maybe<List<MovieEntity>> getListMovie();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    Maybe<Long> insertMovie(MovieEntity movieEntity);

    @Update(onConflict = OnConflictStrategy.REPLACE)
    Maybe<Integer> updateMovie(MovieEntity movieEntity);
}
