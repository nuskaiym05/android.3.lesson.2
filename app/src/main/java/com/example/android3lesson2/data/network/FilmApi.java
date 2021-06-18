package com.example.android3lesson2.data.network;


import com.example.android3lesson2.data.model.FilmModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface FilmApi {

    @GET("films")
    Call<List<FilmModel>> getFilms();

    @GET("films/{id}")
    Call<FilmModel> getFilmById(
            @Path("id") String id
    );


}
