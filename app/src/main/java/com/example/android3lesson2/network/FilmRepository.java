package com.example.android3lesson2.network;

import com.example.android3lesson2.model.FilmModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FilmRepository {


    public static void getFilm(FilmCallback callback) {
        FilmService.getInstance().getFilmApi().getFilms().enqueue(new Callback<List<FilmModel>>() {
            @Override
            public void onResponse(Call<List<FilmModel>> call, Response<List<FilmModel>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    callback.onSuccess(response.body());
                } else {
                    callback.onFailure(response.message());
                }
            }

            @Override
            public void onFailure(Call<List<FilmModel>> call, Throwable t) {
                callback.onFailure(t.getMessage());
            }
        });
    }

    public static void getFilmById(String id, FilmByIdCallback callback) {
        FilmService.getInstance().getFilmApi().getFilmById(id).enqueue(new Callback<FilmModel>() {
            @Override
            public void onResponse(Call<FilmModel> call, Response<FilmModel> response) {
                if (response.isSuccessful() && response.body() != null) {
                    callback.onSuccess(response.body());
                } else {
                    callback.onFailure(response.message());
                }
            }

            @Override
            public void onFailure(Call<FilmModel> call, Throwable t) {
                callback.onFailure(t.getMessage());
            }
        });
    }

    public interface FilmCallback {
        void onSuccess(List<FilmModel> list);

        void onFailure(String message);
    }

    public interface FilmByIdCallback {
        void onSuccess(FilmModel model);

        void onFailure(String message);
    }


}
