package com.example.android3lesson2.data.local;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.android3lesson2.data.model.FilmModel;

import java.util.List;

@Dao
public interface FilmDao {

    @Query("SELECT * FROM filmModel")
    List<FilmModel> getFilms();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertFilms(FilmModel model);
}
