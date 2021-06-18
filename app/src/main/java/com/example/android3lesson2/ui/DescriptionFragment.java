package com.example.android3lesson2.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.android3lesson2.data.model.FilmModel;
import com.example.android3lesson2.data.network.FilmRepository;
import com.example.android3lesson2.databinding.FragmentDescriptionBinding;
import com.example.android3lesson2.ui.film.FilmFragment;
import com.example.android3lesson2.ui.saved.SavedFragment;

import org.jetbrains.annotations.NotNull;

public class DescriptionFragment extends Fragment {

    protected FragmentDescriptionBinding binding;
    protected String id;
    protected FilmModel model;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentDescriptionBinding.inflate(inflater);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull @NotNull View view, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if (getArguments() != null) {
            id = getArguments().getString(FilmFragment.ID);
            if (id != null) {
                getFilmById(id);
            }
            model = (FilmModel) getArguments().getSerializable(SavedFragment.MODEL);
            if (model != null) {
                setTextModel(model);
            }
        }
    }

    private void getFilmById(String id) {
        FilmRepository.getFilmById(id, new FilmRepository.FilmByIdCallback() {
            @Override
            public void onSuccess(FilmModel model) {
                setTextModel(model);
            }

            @Override
            public void onFailure(String message) {
            }
        });
    }

    private void setTextModel(FilmModel model) {
        binding.textTitleFragmentDescription.setText(model.getTitle());
        binding.textDescriptionFragmentDescription.setText(model.getDescription());
    }
}