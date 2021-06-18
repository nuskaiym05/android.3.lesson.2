package com.example.android3lesson2.data.local;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.android3lesson2.data.model.FilmModel;

@Database(entities = FilmModel.class, exportSchema = false, version = 1)
public abstract class FilmDataBase extends RoomDatabase {
    public abstract FilmDao filmDao();
}
