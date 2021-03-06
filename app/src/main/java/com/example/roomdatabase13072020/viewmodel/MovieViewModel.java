package com.example.roomdatabase13072020.viewmodel;

import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.roomdatabase13072020.model.entities.MovieEntity;
import com.example.roomdatabase13072020.repository.MovieRepository;

import java.util.List;

import io.reactivex.MaybeObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class MovieViewModel extends ViewModel {
    private MutableLiveData<List<MovieEntity>> mArrayMovie;
    private MutableLiveData<Long> mRowIdInsert;
    private MutableLiveData<Integer> mRowIdUpdate;
    private MovieRepository mMovieRepository;

    public MovieViewModel(Context context) {
        this.mArrayMovie = new MutableLiveData<>();
        this.mRowIdInsert = new MutableLiveData<>();
        this.mRowIdUpdate = new MutableLiveData<>();
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
    public void insertMovie(MovieEntity movieEntity){
        mMovieRepository
                .insertMovie(movieEntity)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new MaybeObserver<Long>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onSuccess(Long aLong) {
                        mRowIdInsert.setValue(aLong);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
    public LiveData<Long> getRowIdInsert(){
        return mRowIdInsert;
    }

    public void updateMovie(MovieEntity movieEntity){
        mMovieRepository
                .updateMovie(movieEntity)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new MaybeObserver<Integer>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onSuccess(Integer integer) {
                        mRowIdUpdate.setValue(integer);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
    public LiveData<Integer> getRowIdUpdate(){
        return mRowIdUpdate;
    }

}
