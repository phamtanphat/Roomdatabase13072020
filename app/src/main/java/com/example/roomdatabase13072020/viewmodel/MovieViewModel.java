package com.example.roomdatabase13072020.viewmodel;

import android.content.Context;
import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.roomdatabase13072020.model.entities.MovieEntity;
import com.example.roomdatabase13072020.repository.MovieRepository;

import org.reactivestreams.Subscription;

import java.util.List;

import io.reactivex.FlowableSubscriber;
import io.reactivex.MaybeObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class MovieViewModel extends ViewModel {
    private MutableLiveData<List<MovieEntity>> mArrayMovie;
    private MovieRepository mMovieRepository;

    public MovieViewModel(Context context) {
        this.mArrayMovie = new MutableLiveData<>();
        mMovieRepository = MovieRepository.getInstance(context);
    }

    public void callListMovie(){
        mMovieRepository
                .getListMovie()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new MaybeObserver<List<MovieEntity>>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onSuccess(List<MovieEntity> movieEntities) {
                        mArrayMovie.setValue(movieEntities);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    public LiveData<List<MovieEntity>> getListMovie(){
        return mArrayMovie;
    }

}
