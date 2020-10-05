package com.example.roomdatabase13072020.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.util.Log;

import com.example.roomdatabase13072020.R;
import com.example.roomdatabase13072020.model.entities.MovieEntity;
import com.example.roomdatabase13072020.viewmodel.MovieViewModel;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    MovieViewModel mMovieViewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mMovieViewModel = new MovieViewModel(this);


        mMovieViewModel.getListMovie().observe(this, new Observer<List<MovieEntity>>() {
            @Override
            public void onChanged(List<MovieEntity> movieEntities) {
                Log.d("BBB",movieEntities.size() + "");
            }
        });

        mMovieViewModel.callListMovie();

    }
}