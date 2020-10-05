package com.example.roomdatabase13072020.repository;

import android.content.Context;

import com.example.roomdatabase13072020.database.DatabaseMovie;
import com.example.roomdatabase13072020.database.dao.MovieDao;
import com.example.roomdatabase13072020.model.entities.MovieEntity;

import java.util.List;

import io.reactivex.Flowable;
import io.reactivex.Maybe;

public class MovieRepository {
    private static MovieRepository mInstance = null;
    private MovieDao mMovieDao;

    private MovieRepository(Context context){
        mMovieDao = DatabaseMovie.getDatabase(context).movieDao();
    }
    public static MovieRepository getInstance(Context context){
        if (mInstance == null){
            mInstance = new MovieRepository(context);
        }
        return mInstance;
    }
    public Maybe<List<MovieEntity>> getListMovie(){
        return mMovieDao.getListMovie();
    }
    public Maybe<Long> insertMovie(MovieEntity movieEntity){
        return mMovieDao.insertMovie(movieEntity);
    }

}
