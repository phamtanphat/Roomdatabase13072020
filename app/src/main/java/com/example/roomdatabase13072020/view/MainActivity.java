package com.example.roomdatabase13072020.view;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;

import com.example.roomdatabase13072020.R;
import com.example.roomdatabase13072020.model.entities.MovieEntity;
import com.example.roomdatabase13072020.viewmodel.MovieViewModel;

import java.io.ByteArrayOutputStream;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    MovieViewModel mMovieViewModel;
    List<MovieEntity> mMovieEntities;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mMovieViewModel = new MovieViewModel(this);


        mMovieViewModel.getListMovie().observe(this, new Observer<List<MovieEntity>>() {
            @Override
            public void onChanged(List<MovieEntity> movieEntities) {
                mMovieEntities = movieEntities;
                Log.d("BBB",movieEntities.size() + "");
            }
        });

        mMovieViewModel.callListMovie();

//        mMovieViewModel.getRowIdInsert().observe(this, new Observer<Long>() {
//            @Override
//            public void onChanged(Long aLong) {
//                Log.d("BBB",aLong + "");
//            }
//        });
//
//        Bitmap bitmap = ((BitmapDrawable)getResources().getDrawable(R.drawable.phim_chan_to_phieu_luu_ky)).getBitmap();
//        ByteArrayOutputStream stream = new ByteArrayOutputStream();
//        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, stream);
//        byte[] bitmapdata = stream.toByteArray();
//
//        mMovieViewModel.insertMovie(new MovieEntity("CHÂN TO PHIÊU LƯU KÝ",bitmapdata,4.0F,"HD"));

        // update

//        mMovieViewModel.getRowIdUpdate().observe(this, new Observer<Integer>() {
//            @Override
//            public void onChanged(Integer integer) {
//                Log.d("BBB",integer + "");
//            }
//        });
//        new Handler().postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                MovieEntity movieEntity = mMovieEntities.get(0);
//                movieEntity.setRating(5.0f);
//                mMovieViewModel.updateMovie(movieEntity);
//            }
//        },2000);
    }
}