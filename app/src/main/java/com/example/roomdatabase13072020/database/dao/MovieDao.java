package com.example.roomdatabase13072020.database.dao;

import androidx.room.Dao;
import androidx.room.Query;

import com.example.roomdatabase13072020.model.entities.MovieEntity;

import java.util.List;

import io.reactivex.Maybe;

@Dao
public interface MovieDao {
    @Query("SELECT * FROM Movie")
    Maybe<List<MovieEntity>> getListMovie();
}
